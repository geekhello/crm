package com.crm.web.action.test.Lucene;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class LuceneDemo {

	@Test
	public void testWriter() throws IOException {
		// 指定索引库存放的路径
		Directory directory = FSDirectory.open(new File("F:\\tmp\\index"));
		// 创建一个分词器:标准分词器
		Analyzer analyzer = new StandardAnalyzer();
		// 创建索引写入配置文件
		// 参数1：lucene的版本信息，参数2：分词器
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
		//　创建索引写入对象
		IndexWriter writer = new IndexWriter(directory, config);
		// 創建原始文檔對象
		File dir = new File("F:\\tmp\\searchsource");
		// 遍歷原始文檔
		for(File file : dir.listFiles()){
			// 文件名
			String fileName = file.getName();
			// 文件内容
			String fileContent = FileUtils.readFileToString(file);
			// 文件路徑
			String filePath = file.getAbsolutePath();
			// 文件大小
			long fileSize = FileUtils.sizeOf(file);
			// 创建文档域
			Field file_name_field = new TextField("file_name", fileName, Store.YES);
			Field file_content_field = new TextField("file_content", fileContent, Store.YES);
			Field file_path_field = new StoredField("file_path", filePath);
			Field file_size_field = new LongField("file_size", fileSize, Store.YES);
			
			// 创建文档对象保存文档域
			Document document = new Document();
			document.add(file_name_field);
			document.add(file_content_field);
			document.add(file_path_field);
			document.add(file_size_field);
			
			// 创建索引
			writer.addDocument(document);
			
		}
		// 关闭索引写入流
		writer.close();
		
	}
	
	@Test
	public void testReader() throws IOException{
		
		// 指定索引库路劲
		Directory directory = FSDirectory.open(new File("F:\\tmp\\index"));
		// 创建索引读取流
		IndexReader reader = DirectoryReader.open(directory);
		// 创建索引查询对象
		IndexSearcher searcher = new IndexSearcher(reader);
		// 创建查询对象
		Query query = new TermQuery(new Term("file_content", "apache"));
		// 执行查询
		TopDocs topDocs = searcher.search(query, 10);
		// 查询结果总条数
		System.out.println("查询总条数："+topDocs.totalHits);
		// 遍历查询结果
		ScoreDoc[] docs = topDocs.scoreDocs;
		for (ScoreDoc doc : docs) {
			// ScoreDoc存储了文档的ID，根据文档ID获得文档对象
			Document document = searcher.doc(doc.doc);
			// 获取文档的文件名/路径/内容/大小等各文档域的内容
			String file_name = document.get("file_name");
			String file_path = document.get("file_path");
			long size = Long.valueOf(document.get("file_size"));
			System.out.println("文件名："+file_name+",路径："+file_path+",大小："+size);
		}
		// 关闭读取流
		reader.close();
	}
	
	@Test
	public void testWriter2() throws IOException{
		// 指定索引库路劲
		Directory directory = FSDirectory.open(new File("F:\\tmp\\index"));
		// 创建索引写入流配置对象
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
		// 创建索引写入流
		IndexWriter writer = new IndexWriter(directory, config);
		// 创建文档域并构建文档对象
		Document document = new Document();
		document.add(new TextField("filename", "新添加的文档", Store.YES));
		document.add(new TextField("content", "新添加的文档的内容", Store.NO));
		document.add(new TextField("content", "新添加的文档的内容第二个content", Store.YES));
		document.add(new TextField("content1", "新添加的文档的内容要能看到", Store.YES));
		// 添加文档到索引库
		writer.addDocument(document);
		
		writer.close();
		
	}
	
	@Test
	public void testReader2() throws IOException{
		
		// 指定索引库路劲
		Directory directory = FSDirectory.open(new File("F:\\tmp\\index"));
		// 创建索引读取流
		IndexReader reader = DirectoryReader.open(directory);
		// 创建索引查询对象
		IndexSearcher searcher = new IndexSearcher(reader);
		// 创建查询对象
		Query query = new TermQuery(new Term("filename", "文档"));
		// 执行查询
		TopDocs topDocs = searcher.search(query, 10);
		// 查询结果总条数
		System.out.println("查询总条数："+topDocs.totalHits);
		// 遍历查询结果
		ScoreDoc[] docs = topDocs.scoreDocs;
		for (ScoreDoc doc : docs) {
			// ScoreDoc存储了文档的ID，根据文档ID获得文档对象
			Document document = searcher.doc(doc.doc);
			// 获取文档的文件名/路径/内容/大小等各文档域的内容
			String file_name = document.get("filename");
			String file_content = document.get("content");
			String file_content1 = document.get("content1");
			System.out.println(file_name+"=="+file_content+"===="+file_content1);
		}
		// 关闭读取流
		reader.close();
	}
	
	@Test
	public void testDelAllIndex() throws IOException{
		// 指定索引库路劲
		Directory directory = FSDirectory.open(new File("F:\\tmp\\index"));
		// 创建索引写入流配置对象
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
		// 创建索引写入流
		IndexWriter writer = new IndexWriter(directory, config);
		
		// 创建文档与搜索对象
		Query query = new TermQuery(new Term("filename", "文档"));
		// 根据条件删除索引库
		writer.deleteAll();
		
		
		writer.close();
		
	}
	
	// 使用MatchAllDocsQuery
	@Test
	public void testQuery1(){
		IndexReader reader = getIndexReader();
		IndexSearcher searcher = new IndexSearcher(reader);
		
		Query query = new MatchAllDocsQuery();
		printResult(query, searcher);
	}
	
	// 使用NumbericRangeQuery
	@Test
	public void testQuery2(){
		IndexSearcher searcher = new IndexSearcher(getIndexReader());
		Query query = NumericRangeQuery.newLongRange("file_size", 0l, 100l, true, true);
		printResult(query, searcher);
	}
	
	// 使用BooleanQuery
	@Test
	public void testQuery()	{
		IndexSearcher searcher = new IndexSearcher(getIndexReader());
		BooleanQuery query = new BooleanQuery();
		Query query1 = new TermQuery(new Term("file_name","apache"));
		Query query2 = new TermQuery(new Term("file_content","apache"));
		//Query query3 = NumericRangeQuery.newLongRange("file_size", 1l, 957l, true, false);
		query.add(query1, Occur.MUST);
		query.add(query2,Occur.MUST);
		//query.add(query3,Occur.MUST);
		printResult(query, searcher);
	}
	
	// 获取IndexReader
	public IndexReader getIndexReader(){
		IndexReader reader = null;
		try{
			// 指定索引库路劲
			Directory directory = FSDirectory.open(new File("F:\\tmp\\index"));
			// 创建索引读取流
			reader = DirectoryReader.open(directory);
			return reader;
		}catch(Exception e){
			e.printStackTrace();
		}
		return reader;
	}
	
	// 打印查询结果
	public void printResult(Query query, IndexSearcher searcher){
		try{
			// 执行查询
			TopDocs topDocs = searcher.search(query, 10);
			// 查询结果总条数
			System.out.println("查询总条数："+topDocs.totalHits);
			// 遍历查询结果
			ScoreDoc[] docs = topDocs.scoreDocs;
			for (ScoreDoc doc : docs) {
				// ScoreDoc存储了文档的ID，根据文档ID获得文档对象
				Document document = searcher.doc(doc.doc);
				// 获取文档的文件名/路径/内容/大小等各文档域的内容
				String file_name = document.get("file_name");
				String file_path = document.get("file_path");
				long size = Long.valueOf(document.get("file_size"));
				System.out.println("文件名："+file_name+",路径："+file_path+",大小："+size);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
