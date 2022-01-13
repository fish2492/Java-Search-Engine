/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author Fish
 */

public class FileSearch
{
    
    private static final String mainDirectory = "C:\\Users\\Fish";
    private LoadAllFiles userFiles;
   
    public FileSearch()throws Exception{
            userFiles = new LoadAllFiles(mainDirectory);
            
    }
    public  ArrayList search(String key,String FileType) throws Exception 
    {
             
           ArrayList searchResultFiles = new ArrayList();
           


           ArrayList zfiles = userFiles.getAllFiles();
           ArrayList zfileNames = userFiles.getAllFileNames();
           System.out.println(zfiles.size());
           ArrayList resultIndex = getIndexSearch(zfileNames, key,FileType);
           
           for(int i =0;i<resultIndex.size();i++)
           searchResultFiles.add(zfiles.get((int)resultIndex.get(i)));

    
        return searchResultFiles;
                
    }

        

    private  ArrayList getIndexSearch( ArrayList list,String key,String Filetype )
    {
         ArrayList resultIndexs = new ArrayList();
        
         for(int i =0 ;i<list.size(); i++)
            {
                String str = (String)list.get(i);
                if (str.indexOf(Filetype) !=-1)
                { 
                     if ( str.indexOf(key)  != -1 )
                    {
                         
                        resultIndexs.add(i);
    
                    }
             
               }
    
            }
        
        return resultIndexs;

    }    


}
