package kr.or.ddit.upload.web;

public class FileUtil {
	
	//파일 업로드 경로
	public final static String fileUploadPath = "D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload";
  
   /**
   * Method : getFileName
   * 최초작성일 : 2018. 7. 16.
   * 작성자 : PC23
   * 변경이력 :
   * @param contentDisposition
   * @return
   * Method 설명 : part의 Content-Disposition header로 부터
   *             업로드 파일명을 리턴한다.
   * 
   * ex ) form-data; name=\"uploadFile\"; fileName=\"moon.png"\;
   */
   public static String getFileName(String contentDisposition){
      String[] cdSplit = contentDisposition.split("; ");
      String fileName = "";
      for (String str : cdSplit) {
         if(str.startsWith("filename")){
        	 fileName = str.substring("filename".length()+2,str.length()-1);
            break;
         }
      }
            
      return fileName;
   }
   
}