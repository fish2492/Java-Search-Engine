/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.ArrayList;
import java.io.File;


/**
 *
 * @author Fish
 */
public class LoadAllFiles 
{

    String uperPath;

    ArrayList allFileNames=new ArrayList();
    ArrayList allFiles = new ArrayList();


    public LoadAllFiles(String Path) throws Exception
    {
        uperPath = Path;
        
            
            ArrayList[] d = getAllFiles(uperPath );
            allFiles = d[0];
            allFileNames = d[1];
        
       
     }
   
    public ArrayList getAllFiles()
    {
        return allFiles;
    }

    public ArrayList getAllFileNames()
    {
        return allFileNames;
        
    }
    

 

    // this method loads every file in a given path
    // directories
    // it users recursion 
    private ArrayList[] getAllFiles(String path ) throws Exception
    {
        
         ArrayList allFiles = new ArrayList();
         ArrayList allFileNames = new ArrayList();
         rec(path,allFiles,allFileNames);
 
         ArrayList[]  d = new ArrayList[2];   
         d[0] = allFiles;
         d[1] = allFileNames;
         return d;
    }
    
    private void rec(String path,ArrayList allFiles,ArrayList allFileNames ) throws Exception
    {   
            File d = new File(path);
            
            File[]  fileList = d.listFiles();
            String[] fileNameList =  d.list();
            //add all the files to the all Files
             

            for(int i=0;i<fileList.length;i++)
                         allFiles.add(fileList[i]);
            
             for(int i=0;i<fileList.length;i++)
                         allFileNames.add(fileNameList[i]);
              
            for ( int i=0;i<fileList.length;i++)
            {  
             
                    
                   if(fileList[i].isDirectory())
                    {
                        try{
                            rec(fileList[i].getAbsolutePath(),allFiles,allFileNames);
                        }catch(NullPointerException e)
                            {    }
                    }
                
                
            }

     } 
    

}


