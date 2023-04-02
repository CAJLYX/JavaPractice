import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractContent {
    
    public static void main(String[] args) throws IOException {
        //1 ��ȡgene_idΪkey  gene_nameΪvalue ��hashMap
        HashMap<String, String> geneMap = getGeneMap();
        String basedir = "D:\\BaiduNetdiskDownload\\103panGenes\\04.idTrans\\";
        String sourcedir = "D:\\BaiduNetdiskDownload\\103panGenes\\04.idTrans\\source";
        File parentFile = new File(sourcedir);
        String[] fileNames = parentFile.list();
        System.out.println("�ļ�����"+fileNames.length);
        int i = 0;
        for (String fileName : fileNames) {
            System.out.println(fileName + "  ��" + ++i +"��");
            //2 ������ȡ�ļ�ÿһ�У�Ensembl_ID��ǰ׺����geneMap��keyֵ����ǰ׺�滻��geneMap��value
            changeFile(geneMap, fileName,basedir);
        }
    }

    private static void changeFile(HashMap<String, String> geneMap, String fileName, String basedir) throws IOException {
        String filePath = basedir + "source\\" +fileName;
        String newFileName = "symbol."+ fileName.substring(fileName.indexOf("-")+1, fileName.indexOf("."))+".txt";
        String newFilePath = basedir + "result\\" + newFileName;
        File file = new File(filePath);
        File newFile = new File(newFilePath);
        if(file.isFile() && file.exists()){
            //������  ��ȡ�ļ�����
            InputStreamReader reader = new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            //����� ���ļ�д������
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile),"UTF-8"));
            String str;
            while((str = bufferedReader.readLine()) != null){
                //�Ǳ�����
                if(str.contains(".")){
                    int id = str.indexOf("\t");
                    String substring = str.substring(0, id);
                    String substring1 = substring.substring(0, substring.indexOf("."));
                    if(geneMap.containsKey(substring1)){
                        str = str.replace(substring, geneMap.get(substring1));
                    }else {
                        continue;
                    }
                }
                bufferedWriter.write(str+"\n");
            }
            bufferedWriter.close();
            bufferedReader.close();
            reader.close();
        }
    }

    private static HashMap<String,String> getGeneMap() {
        HashMap<String, String> geneMap = new HashMap<>();
        String filePath = "D:\\BaiduNetdiskDownload\\103panGenes\\04.idTrans\\human.gtf";
        File file = new File(filePath);
        if(file.isFile() && file.exists()){
            try {
                InputStreamReader reader = new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String str;
                while((str = bufferedReader.readLine()) != null){
                    //ͨ��������ʽ�ҳ�ָ�����ַ�������
                    Pattern patternGeneId = Pattern.compile("gene_id \"\\w+\"");
                    Pattern patternGeneName = Pattern.compile("gene_name \"\\w+\"");
                    Matcher matcherGeneId = patternGeneId.matcher(str);
                    Matcher matcherGeneName = patternGeneName.matcher(str);
                    if(matcherGeneId.find() && matcherGeneName.find()){
                        //�ҳ����ַ��� gene_id "ENSG00000223972" ��һ�����ŵ�����  �ڶ������ŵ�����
                        String gene_id = matcherGeneId.group();
                        int first = gene_id.indexOf("\"");
                        int end = gene_id.lastIndexOf("\"");
                        String key = gene_id.substring(first+1,end);
                        //�ҳ����ַ��� gene_name "DDX11L1"  ��һ�����ŵ�����  �ڶ������ŵ�����
                        String gene_name = matcherGeneName.group();
                        int fist1 = gene_name.indexOf("\"");
                        int end1 = gene_name.lastIndexOf("\"");
                        String value = gene_name.substring(fist1 + 1, end1);
                        geneMap.put(key,value);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(geneMap);
        return geneMap;
    }
}
