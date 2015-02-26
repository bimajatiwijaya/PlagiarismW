package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class preprocess {
	private static String[] sw= new String[] {"1","2","3","4","5","6","7","8","9","0","a.","b.","c.","d.","e.","f.","g.","h.","i.","abad","acara","aceh","ada","adalah","adanya","adapun","agak","agaknya","agama","agar","agustus","air","akan","akankah","akhir","akhiri","akhirnya","akibat","aku","akulah","alam","album","amat","amatlah","amerika","anak","and","anda","andalah","anggota","antar","antara","antarabangsa","antaranya","apa","apaan","apabila","apakah","apalagi","apatah","api","april","artikel","artinya","as","asal","asalkan","asas","asia","asing","atas","atau","ataukah","ataupun","australia","awal","awalnya","awam","badan","bagai","bagaikan","bagaimana","bagaimanakah","bagaimanapun","bagainamakah","bagi","bagian","bahagian","bahan","baharu","bahasa","bahawa","bahkan","bahwa","bahwasannya","bahwasanya","baik","baiknya","bakal","bakalan","balik","bandar","bangsa","bank","banyak","bapak","barang","barangan","barat","baru","baru-baru","bawah","beberapa","begini","beginian","beginikah","beginilah","begitu","begitukah","begitulah","begitupun","bekas","bekerja","belakang","belakangan","belanda","beli","beliau","belum","belumlah","benar","benarkah","benarlah","bentuk","berada","berakhir","berakhirlah","berakhirnya","berapa","berapakah","berapalah","berapapun","berarti","berasal","berat","berawal","berbagai","berbanding","berbeda","berdasarkan","berdatangan","berharap","berhasil","beri","berikan","berikut","berikutan","berikutnya","berita","berjalan","berjaya","berjumlah","berkaitan","berkali","berkali-kali","berkata","berkehendak","berkeinginan","berkenaan","berlainan","berlaku","berlalu","berlangsung","berlebihan","bermacam","bermacam-macam","bermain","bermaksud","bermula","bernama","bernilai","bersama","bersama-sama","bersiap","bertanya","bertemu","berturut","bertutur","berubah","berujar","berupa","besar","besok","betul","betulkah","bhd","biasa","biasanya","bidang","bila","bilakah","bilion","bintang","bisa","bisakah","blog","bn","bola","boleh","bolehkah","bolehlah","buat","bukan","bukankah","bukanlah","bukannya","buku","bulan","bumi","bung","bursa","cadangan","cara","caranya","catch","china","click","code","copyright","cukup","cukupkah","cukuplah","cuma","daerah","dagangan","dahulu","dalam","dan","dana","dapat","dari","daripada","dasar","data","datang","datuk","dekat","demi","demikian","demikianlah","dengan","depan","derivatives","desa","desember","detik","dewan","di","dia","diadakan","diakhiri","diakhirinya","dialah","dianggap","diantara","diantaranya","diberi","diberikan","diberikannya","dibuat","dibuatnya","dibuka","dicatatkan","didapat","didatangkan","didirikan","diduga","digunakan","diibaratkan","diibaratkannya","diingat","diingatkan","diinginkan","dijangka","dijawab","dijelaskan","dijelaskannya","dikarenakan","dikatakan","dikatakannya","dikenal","dikerjakan","diketahui","diketahuinya","dikira","dilakukan","dilalui","dilihat","dimaksud","dimaksudkan","dimaksudkannya","dimaksudnya","dimana","diminta","dimintai","dimisalkan","dimulai","dimulailah","dimulainya","dimungkinkan","dini","diniagakan","dipastikan","diperbuat","diperbuatnya","dipergunakan","diperkirakan","diperlihatkan","diperlukan","diperlukannya","dipersoalkan","dipertanyakan","dipunyai","diri","dirilis","dirinya","dis","disampaikan","disebut","disebutkan","disebutkannya","disember","disini","disinilah","distrik","ditambahkan","ditandaskan","ditanya","ditanyai","ditanyakan","ditegaskan","ditemukan","ditujukan","ditunjuk","ditunjuki","ditunjukkan","ditunjukkannya","ditunjuknya","ditutup","dituturkan","dituturkannya","diucapkan","diucapkannya","diungkapkan","document.write","dolar","dong","dr","dua","dulu","dunia","effective","ekonomi","eksekutif","eksport","empat","enam","enggak","enggaknya","entah","entahlah","era","eropa","err","faedah","feb","film","gat","gedung","gelar","gettracker","global","grup","guna","gunakan","gunung","hadap","hadapan","hal","hampir","hanya","hanyalah","harga","hari","harian","harus","haruslah","harusnya","hasil","hendak","hendaklah","hendaknya","hidup","hingga","https","hubungan","hukum","hutan","ia","iaitu","ialah","ibarat","ibaratkan","ibaratnya","ibu","ii","iklan","ikut","ilmu","indeks","india","indonesia","industri","informasi","ingat","inggris","ingin","inginkah","inginkan","ini","inikah","inilah","internasional","islam","isnin","isu","italia","itu","itukah","itulah","jabatan","jadi","jadilah","jadinya","jakarta","jalan","jalur","jaman","jan","jangan","jangankan","janganlah","januari","jauh","jawa","jawab","jawaban","jawabnya","jawatan","jawatankuasa","jelas","jelaskan","jelaslah","jelasnya","jenis","jepang","jepun","jerman","jika","jikalau","jiwa","jual","jualan","juga","julai","jumaat","jumat","jumlah","jumlahnya","jun","juni","justru","juta","kabar","kabupaten","kadar","kala","kalangan","kalau","kalaulah","kalaupun","kali","kalian","kalimantan","kami","kamilah","kamis","kamu","kamulah","kan","kantor","kapal","kapan","kapankah","kapanpun","karena","karenanya","karya","kasus","kata","katakan","katakanlah","katanya","kaunter","kawasan","ke","keadaan","kebetulan","kebutuhan","kecamatan","kecil","kedua","kedua-dua","keduanya","kedudukan","kegiatan","kehidupan","keinginan","kejadian","kekal","kelamaan","kelihatan","kelihatannya","kelima","kelompok","keluar","keluarga","kelurahan","kembali","kementerian","kemudahan","kemudian","kemungkinan","kemungkinannya","kenaikan","kenapa","kenyataan","kepada","kepadanya","kepala","kepentingan","keputusan","kerajaan","kerana","kereta","kerja","kerjasama","kes","kesampaian","keselamatan","keseluruhan","keseluruhannya","kesempatan","kesihatan","keterangan","keterlaluan","ketiga","ketika","ketua","keuntungan","kewangan","khamis","khusus","khususnya","kini","kinilah","kira","kira-kira","kiranya","kita","kitalah","klci","klibor","klik","km","kok","komentar","kompas","komposit","kondisi","kontrak","korban","korea","kos","kota","kuala","kuasa","kukuh","kumpulan","kurang","kurangnya","lagi","lagian","lagu","lah","lain","lainnya","laku","lalu","lama","lamanya","langkah","langsung","lanjut","lanjutnya","laporan","laut","lebih","lembaga","lepas","lewat","lima","lingkungan","login","lokasi","lot","luar","luas","lumpur","mac","macam","mahkamah","mahu","majlis","maka","makanan","makanya","makin","maklumat","malah","malahan","malam","malaysia","mampu","mampukah","mana","manakala","manalagi","mantan","manusia","masa","masalah","masalahnya","masih","masihkah","masing","masing-masing","masuk","masyarakat","mata","mau","maupun","measure","media","mei","melainkan","melakukan","melalui","melawan","melihat","melihatnya","memandangkan","memang","memastikan","membantu","membawa","memberi","memberikan","membolehkan","membuat","memerlukan","memihak","memiliki","meminta","memintakan","memisalkan","memperbuat","mempergunakan","memperkirakan","memperlihatkan","mempersiapkan","mempersoalkan","mempertanyakan","mempunyai","memulai","memungkinkan","menaiki","menambah","menambahkan","menandaskan","menanti","menantikan","menanya","menanyai","menanyakan","menarik","menawarkan","mencapai","mencari","mencatatkan","mendapat","mendapatkan","mendatang","mendatangi","mendatangkan","menegaskan","menerima","menerusi","mengadakan","mengakhiri","mengaku","mengalami","mengambil","mengapa","mengatakan","mengatakannya","mengenai","mengerjakan","mengetahui","menggalakkan","menggunakan","menghadapi","menghendaki","mengibaratkan","mengibaratkannya","mengikut","mengingat","mengingatkan","menginginkan","mengira","mengucapkan","mengucapkannya","mengumumkan","mengungkapkan","mengurangkan","meninggal","meningkat","meningkatkan","menjadi","menjalani","menjawab","menjelang","menjelaskan","menokok","menteri","menuju","menunjuk","menunjuki","menunjukkan","menunjuknya","menurut","menuturkan","menyaksikan","menyampaikan","menyangkut","menyatakan","menyebabkan","menyebutkan","menyediakan","menyeluruh","menyiapkan","merasa","mereka","merekalah","merosot","merupakan","meski","meskipun","mesyuarat","metrotv","meyakini","meyakinkan","milik","militer","minat","minggu","minta","minyak","mirip","misal","misalkan","misalnya","mobil","modal","mohd","mudah","mula","mulai","mulailah","mulanya","muncul","mungkin","mungkinkah","musik","musim","nah","naik","nama","namun","nanti","nantinya","nasional","negara","negara-negara","negeri","new","niaga","nilai","nomor","noun","nov","november","numeral","numeralia","nya","nyaris","nyatanya","of","ogos","okt","oktober","olah","oleh","olehnya","operasi","orang","organisasi","pada","padahal","padanya","pagetracker","pagi","pak","paling","pameran","panjang","pantas","papan","para","paras","parlimen","partai","parti","particle","pasar","pasaran","password","pasti","pastilah","pasukan","paticle","pegawai","pejabat","pekan","pekerja","pelabur","pelaburan","pelancongan","pelanggan","pelbagai","peluang","pemain","pembangunan","pemberita","pembinaan","pemerintah","pemerintahan","pemimpin","pendapatan","pendidikan","penduduk","penerbangan","pengarah","pengeluaran","pengerusi","pengguna","penggunaan","pengurusan","peniaga","peningkatan","penting","pentingnya","per","perancis","perang","peratus","percuma","perdagangan","perdana","peringkat","perjanjian","perkara","perkhidmatan","perladangan","perlu","perlukah","perlunya","permintaan","pernah","perniagaan","persekutuan","persen","persidangan","persoalan","pertama","pertandingan","pertanyaan","pertanyakan","pertubuhan","pertumbuhan","perubahan","perusahaan","pesawat","peserta","petang","pihak","pihaknya","pilihan","pinjaman","polis","polisi","politik","pos","posisi","presiden","prestasi","produk","program","projek","pronomia","pronoun","proses","proton","provinsi","pt","pubdate","pukul","pula","pulau","pun","punya","pusat","rabu","radio","raja","rakan","rakyat","ramai","rantau","rasa","rasanya","rata","raya","rendah","republik","resmi","ribu","ringgit","root","ruang","rumah","rupa","rupanya","saat","saatnya","sabah","sabtu","sahaja","saham","saja","sajalah","sakit","salah","saling","sama","sama-sama","sambil","sampai","sampaikan","sana","sangat","sangatlah","sarawak","satu","sawit","saya","sayalah","sdn","se","sebab","sebabnya","sebagai","sebagaimana","sebagainya","sebagian","sebahagian","sebaik","sebaiknya","sebaliknya","sebanyak","sebarang","sebegini","sebegitu","sebelah","sebelum","sebelumnya","sebenarnya","seberapa","sebesar","sebetulnya","sebisanya","sebuah","sebut","sebutlah","sebutnya","secara","secukupnya","sedang","sedangkan","sedemikian","sedikit","sedikitnya","seenaknya","segala","segalanya","segera","segi","seharusnya","sehingga","seingat","sejak","sejarah","sejauh","sejenak","sejumlah","sekadar","sekadarnya","sekali","sekali-kali","sekalian","sekaligus","sekalipun","sekarang","sekaranglah","sekecil","seketika","sekiranya","sekitar","sekitarnya","sekolah","sektor","sekurang","sekurangnya","sekuriti","sela","selagi","selain","selaku","selalu","selama","selama-lamanya","selamanya","selanjutnya","selasa","selatan","selepas","seluruh","seluruhnya","semacam","semakin","semalam","semampu","semampunya","semasa","semasih","semata","semaunya","sementara","semisal","semisalnya","sempat","semua","semuanya","semula","sen","sendiri","sendirian","sendirinya","senin","seolah","seolah-olah","seorang","sepak","sepanjang","sepantasnya","sepantasnyalah","seperlunya","seperti","sepertinya","sepihak","sept","september","serangan","serantau","seri","serikat","sering","seringnya","serta","serupa","sesaat","sesama","sesampai","sesegera","sesekali","seseorang","sesi","sesuai","sesuatu","sesuatunya","sesudah","sesudahnya","setelah","setempat","setengah","seterusnya","setiap","setiausaha","setiba","setibanya","setidak","setidaknya","setinggi","seusai","sewaktu","siap","siapa","siapakah","siapapun","siaran","sidang","singapura","sini","sinilah","sistem","soal","soalnya","sokongan","sri","stasiun","suara","suatu","sudah","sudahkah","sudahlah","sukan","suku","sumber","sungai","supaya","surat","susut","syarikat","syed","tadi","tadinya","tahap","tahu","tahun","tak","tama","tambah","tambahnya","tampak","tampaknya","tampil","tan","tanah","tandas","tandasnya","tanggal","tanpa","tanya","tanyakan","tanyanya","tapi","tawaran","tegas","tegasnya","teknologi","telah","televisi","teman","tempat","tempatan","tempo","tempoh","tenaga","tengah","tentang","tentara","tentu","tentulah","tentunya","tepat","terakhir","terasa","terbaik","terbang","terbanyak","terbesar","terbuka","terdahulu","terdapat","terdiri","terhadap","terhadapnya","teringat","terjadi","terjadilah","terjadinya","terkait","terkenal","terkira","terlalu","terlebih","terletak","terlihat","termasuk","ternyata","tersampaikan","tersebut","tersebutlah","tertentu","tertuju","terus","terutama","testimoni","testimony","tetap","tetapi","the","tiada","tiap","tiba","tidak","tidakkah","tidaklah","tidaknya","tiga","tim","timbalan","timur","tindakan","tinggal","tinggi","tingkat","toh","tokoh","try","tun","tunai","tunjuk","turun","turut","tutur","tuturnya","tv","uang","ucap","ucapnya","udara","ujar","ujarnya","umum","umumnya","unescape","ungkap","ungkapnya","unit","universitas","untuk","untung","upaya","urus","usah","usaha","usai","user","utama","utara","var","versi","waduh","wah","wahai","wakil","waktu","waktunya","walau","walaupun","wang","wanita","warga","warta","wib","wilayah","wong","word","ya","yaitu","yakin","yakni","yang","zaman","-"};;
	public String StopWords(String Document)
	{
	    String[] words = Document.split(" ");
	    ArrayList<String> wordsList = new ArrayList<String>();
	    Set<String> stopWordsSet = new HashSet<String>();
	    int i,len = sw.length;
	    for(i=0;i<len;i++)
		{
	    	stopWordsSet.add(sw[i]);
		}

	    for(String word : words)
	    {
	        String wordCompare = word;
	        //System.out.println(wordCompare);
	        if(!stopWordsSet.contains(wordCompare))
	        {
	            wordsList.add(word);
	        }
	    }
	    return wordsList.toString();
	}
	public String readAllPDF(String PdfPath)
	{
		File actual = new File(PdfPath);
		String address = PdfPath;
		String parsedText = null;
        for( File f : actual.listFiles())
        {
            PDFTextStripper pdfStripper = null;
		    PDDocument pdDoc = null;
		    COSDocument cosDoc = null;
		    File file = new File(address+f.getName());
		    try {
		    	System.out.println("------------------------------------------------");
		        PDFParser parser = new PDFParser(new FileInputStream(file));
		        parser.parse();
		        cosDoc = parser.getDocument();
		        pdfStripper = new PDFTextStripper();
		        pdDoc = new PDDocument(cosDoc);
		        pdfStripper.setStartPage(1);
		        //pdfStripper.setEndPage(10);
		        parsedText = pdfStripper.getText(pdDoc);
		        pdDoc.close();
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		        } 
		    }
		return parsedText;
	}
	// read pdfpath and return in string type
	public String readOnePdf(String PdfPath)
	{
		String parsedText = null;
        PDFTextStripper pdfStripper = null;
	    PDDocument pdDoc = null;
	    COSDocument cosDoc = null;
	    File file = new File(PdfPath);
	    try {
	        PDFParser parser = new PDFParser(new FileInputStream(file));
	        parser.parse();
	        cosDoc = parser.getDocument();
	        pdfStripper = new PDFTextStripper();
	        pdDoc = new PDDocument(cosDoc);
	        pdfStripper.setStartPage(1);
	        pdfStripper.setEndPage(5);
	        parsedText = pdfStripper.getText(pdDoc);
	        pdDoc.close();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } 
		return parsedText;
	}
	/**
	 File actual = new File("C:/update/xampp/htdocs/ta/fileTAFix/");
		String address = "C:/update/xampp/htdocs/ta/fileTAFix/";
        for( File f : actual.listFiles())
        {
            PDFTextStripper pdfStripper = null;
		    PDDocument pdDoc = null;
		    COSDocument cosDoc = null;
		    File file = new File(address+f.getName());
		    try {
		    	System.out.println("------------------------------------------------");
		        PDFParser parser = new PDFParser(new FileInputStream(file));
		        parser.parse();
		        cosDoc = parser.getDocument();
		        pdfStripper = new PDFTextStripper();
		        pdDoc = new PDDocument(cosDoc);
		        pdfStripper.setStartPage(1);
		        pdfStripper.setEndPage(10);
		        String parsedText = pdfStripper.getText(pdDoc);
		        System.out.println("Awal : "+parsedText.length());
		        parsedText = parsedText.toLowerCase();
		        parsedText = parsedText.replace(",", "");
//		        System.out.println(parsedText);
		        parsedText = parsedText.replace(".","");
		        parsedText = parsedText.replace("\t","");
		        parsedText = parsedText.replace(System.getProperty("line.separator"), "");
		        //parsedText = stopWord(parsedText);
		        parsedText = sw2(parsedText);
		        parsedText = parsedText.replace(",", "");
		        parsedText = parsedText.replace(")", "");
		        parsedText = parsedText.replace("(", "");
		        parsedText = parsedText.replace("?", "");
		        //parsedText = parsedText.replace(" ", "");
		        parsedText = parsedText.replace(System.getProperty("line.separator"), "");
		        System.out.println("Hasil StopWords : "+parsedText.length());
		        System.out.println(parsedText);
//		        
		        //--String a = java.util.Arrays.toString(parsedText.split("\\ "));
//		        parsedText = parsedText.replaceAll(",", "");
//		        parsedText = parsedText.replaceAll("\\r\\n|\\r|\\n", "");
//		        parsedText = parsedText.replaceAll(System.getProperty("line.separator"), "");
//		        parsedText = parsedText.replaceAll(":", "");
		        pdDoc.close();
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		        } 
		    }
	 */
}
