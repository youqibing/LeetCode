package Tree.Problem;

import java.io.File;
import java.util.LinkedList;

public class SerachDirectory {

    public static void main(String args[]){

    }

    /**
     * 递归遍历算法
     */
    private void getDirectory(File file){

        File flist[] = file.listFiles();
        if(flist == null || flist.length == 0){
            return ;
        }

        for(File f: flist){
            if(f.isDirectory()){
                //列出所有的文件夹
                System.out.println("Dir==>" + f.getAbsolutePath());
                getDirectory(f);
            }else {
                //列出所有的文件
                System.out.println("file==>" + f.getAbsolutePath());
            }
        }
    }

    /**
     * 非递归遍历算法
     */
    private void getDirectorySize(File file){

        LinkedList<File> list = new LinkedList<>(); //保存待遍历文件夹的列表

        File[] files = file.listFiles();
        for(File f: files){
            if(f.isDirectory()){
                System.out.println("Dir==>" + f.getAbsolutePath());
                list.add(f);
            }else {
                System.out.println("file==>" + f.getAbsolutePath());
            }
        }

        File temp_file;
        while(!list.isEmpty()){
            temp_file = list.removeFirst();   //（重要！！！）遍历一个文件夹并删除之
            files = temp_file.listFiles();

            for(File f : files){
                if(f.isDirectory()){
                    System.out.println("Dir==>" + f.getAbsolutePath());
                    list.add(f);
                }else {
                    System.out.println("file==>" + f.getAbsolutePath());
                }
            }

        }

    }


}
