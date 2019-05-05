package pdf;
import java.awt.Rectangle;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingColor;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingColorN;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingColorSpace;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingDeviceCMYKColor;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingDeviceGrayColor;
import org.apache.pdfbox.contentstream.operator.color.SetNonStrokingDeviceRGBColor;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingColor;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingColorN;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingColorSpace;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingDeviceCMYKColor;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingDeviceGrayColor;
import org.apache.pdfbox.contentstream.operator.color.SetStrokingDeviceRGBColor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingMode;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
public class TextColorAndBold extends PDFTextStripper
{
    public int count = 0;
	public class sizey{
		float size;
		float y;
		sizey(float a,float b){
			this.size=a;
			this.y=b;
		}
	}
	
	public String characters = "";
    public TextColorAndBold() throws IOException
    {
        addOperator(new SetStrokingColorSpace());
        addOperator(new SetNonStrokingColorSpace());
        addOperator(new SetStrokingDeviceCMYKColor());
        addOperator(new SetNonStrokingDeviceCMYKColor());
        addOperator(new SetNonStrokingDeviceRGBColor());
        addOperator(new SetStrokingDeviceRGBColor());
        addOperator(new SetNonStrokingDeviceGrayColor());
        addOperator(new SetStrokingDeviceGrayColor());
        addOperator(new SetStrokingColor());
        addOperator(new SetStrokingColorN());
        addOperator(new SetNonStrokingColor());
        addOperator(new SetNonStrokingColorN());

        setSuppressDuplicateOverlappingText(false);
    }
   



	public static void main(String[] args) throws IOException 
    {
            // 输入文件
			try (PDDocument document = PDDocument.load(new File("C:\\Users\\Administrator\\Desktop\\4214.pdf")))
            {
            	TextColorAndBold stripper = new TextColorAndBold();
                stripper.setSortByPosition(true);
                stripper.setStartPage(0);
                stripper.setEndPage(1);
//                stripper.setEndPage(document.getNumberOfPages());

                // 输出文件
                File file = new File("C:\\Users\\Administrator\\Desktop\\4214_unicode3.txt");
                try{
                    System.setOut(new PrintStream(new FileOutputStream(file)));
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
                
                Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
                stripper.writeText(document, dummy);
                float yform=0;
                System.out.println();
//                System.out.println(max);
                if(max<30 && max>1)
	              {System.out.print("The Main Title : " );
	                for(int i=0;i<ss.size();i++){
	                	if(sy.get(i).size==max){
	                		if(sy.get(i).y==yform){
	                		System.out.print(ss.get(i));
	                		}
	                		else {
	                			yform=sy.get(i).y;
	                			System.out.println();
	                			System.out.print("  "+ss.get(i));
	                		}
	                	}
	                	else{
	                		if(sy.get(i).size>sec){
	                			sec=sy.get(i).size;
	                		}
	                	}
	                }
                }
//                System.out.println(sec);
                yform=0;
                if(sec<20 && sec>1)
	            {System.out.println();
	                System.out.print("The SubTitle : " );
	                for(int i=0;i<ss.size();i++){
	                	if(sy.get(i).size==sec){
	                		if(sy.get(i).y==yform){
		                		System.out.print(ss.get(i));
		                		}
		                		else {
		                			yform=sy.get(i).y;
		                			System.out.println();
		                			System.out.print("  "+ss.get(i));
		                		}
	                	}
	                }
            	}
//                System.out.println(ss);
//                stripper.characters.replace(" ", System.getProperty("line.separator"));
//                stripper.characters.replace(" ", System.getProperty("line.separator"));
//                System.out.println("");
//                System.out.println(stripper.characters);
           
                
	            }
    }
	static List<String> ss = new ArrayList<String>();
    static List<sizey> sy = new ArrayList<sizey>();
	static float max=0;
	static float sec=0;
	int flag=0;

	@Override
    protected void processTextPosition(TextPosition text)
    {
        super.processTextPosition(text);

        PDColor nonStrokingColor = getGraphicsState().getNonStrokingColor();	// 获取颜色
        String unicode = text.getUnicode();	// 获取字符
        RenderingMode renderingMode = getGraphicsState().getTextState().getRenderingMode();	
        if(text.getFont().getName().toLowerCase().contains("bold")){ 
        	// 判断是否加粗
        	
        }
        
        // 打印每个字符
      
     
        
//        characters += unicode;
//         打印每个字符的具体信息
//        System.out.println("id="+count); count++;
//         System.out.print(unicode);
//        System.out.println(nonStrokingColor);
////        System.out.println(renderingMode);
//        System.out.println(text.getX() + ", " + text.getY());
//        System.out.println(text.getFont().getName().toLowerCase());
////        System.out.println(text.getFont().getName().toLowerCase().contains("bold"));
//        System.out.println(text.getFontSize());
////        System.out.println(text.getWidth() + text.getX());
////        System.out.println(text.getEndX());
//        System.out.println(text.getHeight());
//        System.out.println(text.getWidth());
        
//        System.out.print("[");
//        for (int i=0; i<nonStrokingColor.getComponents().length; i++) {
//        	System.out.print(nonStrokingColor.getComponents()[i] + ", ");
//        }
//        System.out.println("]");
       
        if((int)(text.getY())==53||(int)text.getY()==41){
        if(flag==0){
        	System.out.print("Date: ");
        	System.out.print(unicode);
        	flag=1;}
        else System.out.print(unicode);
        }
        
        try{
        	if(nonStrokingColor.toRGB()==14440||nonStrokingColor.toRGB()==608641){
        	  if(text.getFontSize()>max) {
        		  max=text.getFontSize();
        	  }
          	  ss.add(unicode);
//          	  System.out.println(text.getFontSize());
          	  sy.add(new sizey(text.getFontSize(),text.getY()));    
            }
//        	System.out.println(nonStrokingColor.toRGB());
        }catch(Exception ex){      	
        }
    }
    

}
