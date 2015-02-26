package service;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import main.preprocess;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import connector.MONGODB;
@Path("clocal")
public class CrawLocal {
	// path final project
	public static String FinalProjectPath = "C:/bima data/skripsi/luna/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/RESTfulWS/final/";
	@POST
	@Path("/getuniq")
	@SuppressWarnings("unchecked")
	public String GetUniqueProject()
	{
		//list examples from service /g/getlistthesis
		String[] ListFiles = new String[] {"A11.2011.05929.pdf","A11.2011.05930.pdf","A11.2011.05931.pdf","A11.2011.05932.pdf","A11.2011.05933.pdf"};
		ArrayList<String> UniqFile = new ArrayList<String>();
		JSONObject output_json = new JSONObject();
		try 
		{
			int i=0,count = ListFiles.length;
			while(i<count)
			{
				if(this.IsUniq(ListFiles[i]))
				{
					UniqFile.add(ListFiles[i]);
				}
				i++;
			}
			if(UniqFile.size()>0)
			{
				output_json.put("code", 1);
				output_json.put("message","sucess");
				output_json.put("data", UniqFile.toString());
			}
			else
			{
				output_json.put("code", 0);
				output_json.put("message","New Project Not Found");
			}
		}catch (Exception e) 
		{
			output_json.put("code", -1);
			output_json.put("message", e.toString());
		}
		return output_json.toString();
	}
	// check url isuniq
	private boolean IsUniq(String url)
	{
		boolean uniq = false;
		DB db = null;
		try 
		{
			db = MONGODB.GetMongoDB();
			DBCollection collLocal = db.getCollection("local");
			BasicDBObject where_query = new BasicDBObject("_id",url);
			DBObject find_objek_student = collLocal.findOne(where_query);
			if (find_objek_student == null)
			{
				uniq = true;
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return uniq;
	}
	//
	@POST
	@Path("/preprocess")
	@SuppressWarnings("unchecked")
	public String PreProcessList()
	{
		JSONObject output_json = new JSONObject();
		JSONObject input_json = new JSONObject();
		DB db = null;
		String StrPdf = null;
		String[] listString = null;
		try 
		{
			db = MONGODB.GetMongoDB();
			DBCollection CollCrawl = db.getCollection("local");
			BasicDBObject objek_db = new BasicDBObject();
			
			String list = this.GetUniqueProject();
			input_json = (JSONObject) JSONValue.parse(list);
			
			list = input_json.get("data").toString();
			list = list.replace("[","");
			list = list.replace("]","");
			list = list.replace(" ","");
			listString = list.split(",");
			int i=0,count = listString.length;
			preprocess ReadPdf = new preprocess();
			while(i<count)
			{
				StrPdf = null;
				objek_db.put("_id",listString[i]);
				objek_db.put("judul", "judul TA "+listString[i]);
				objek_db.put("date", new Date());
				StrPdf = ReadPdf.readOnePdf(FinalProjectPath+listString[i]);
				objek_db.put("rawcontent",StrPdf);
				objek_db.put("cleancontent","");//ReadPdf.StopWords(StrPdf)
				objek_db.put("keyword","keyword "+listString[i]);
				CollCrawl.insert(objek_db);
				i++;
			}
			output_json.put("code", 1);
			output_json.put("message", "sucess");
		}catch (Exception e) 
		{
			output_json.put("code", -1);
			output_json.put("message", e.toString());
		}
		return output_json.toString();
	}
	// check a project has been add to local tabel
	private boolean ProjectExist(DBCollection collLocal,String NameFile)
	{
		boolean uniq = false;
		try 
		{
			BasicDBObject where_query = new BasicDBObject("_id",NameFile);
			DBObject find_objek_project = collLocal.findOne(where_query);
			if (find_objek_project != null)
			{
				uniq = true;
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return uniq;
	}
	//
	@POST
	@Path("/pbynamefile/{appkey}")
	@SuppressWarnings("unchecked")
	public String GetAllProjectByNameFile(@PathParam("appkey") String appkey)
	{
		JSONObject output_json = new JSONObject();
		JSONArray data_json = new JSONArray();
		DB db = null;
		try 
		{
			db = MONGODB.GetMongoDB();
			DBCollection collApp = db.getCollection("application");
			DBCollection collLocal = db.getCollection("local");
			
			GeneralService.AppkeyCheck(appkey,collApp);
			
			DBCursor cursor = collLocal.find();
			while (cursor.hasNext()) {
				data_json.add(cursor.next().get("_id"));
			}
			
			if (data_json.size() == 0)
			{
				output_json.put("code", 0);
				output_json.put("message", "Not Found");
				output_json.put("data", null);
			}else
			{
				output_json.put("code", 1);
				output_json.put("message", "Success");
				output_json.put("data", data_json.toString());
			}
		} 
		catch (Exception e) 
		{
			output_json.put("code", -1);
			output_json.put("message",e.toString());
		}
		
		return output_json.toString();	
	}
	// check
	@POST
	@Path("/plagcheck")
	@SuppressWarnings("unchecked")
	public String PlagiarismCheck(String JsonInput)
	{
		JSONObject output_json = new JSONObject();
		
		DB db = null;
		try 
		{
			db = MONGODB.GetMongoDB();
			JSONObject input_json = (JSONObject) JSONValue.parse(JsonInput);
			DBCollection collApp = db.getCollection("application");
			DBCollection collLocal = db.getCollection("local");
			GeneralService.AppkeyCheck(input_json.get("appkey").toString(),collApp);
			if(!this.ProjectExist(collLocal, input_json.get("NameFile").toString()))
			{
				output_json.put("code", 2);
				output_json.put("message", "Tugas Akhir belum Anda Upload");
			}
			else
			{
				//
			}
		}catch (Exception e) 
		{
			output_json.put("code", -1);
			output_json.put("message", e.toString());
		}
		return output_json.toString();
	}
}
/**
	db.local.insert({"_id":"A11.2011.05929.pdf","judul":"crawling berbasisi ontology","rawcontent":"wkwkkwkwkwkwkwkkwkwkwkkkwkwkwkwkwkkw kwkwkwkwkwk wkwk kwkwkwkwk wkkw kwwkwkk wkkwkwkwkwkwk"})
**/