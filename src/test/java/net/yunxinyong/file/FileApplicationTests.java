package net.yunxinyong.file;

import net.yunxinyong.file.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileApplicationTests {

    @Test
    public void contextLoads() {
        //FileUtils.copyFolder("e:/old", "e:/new");
        File[] fileList = FileUtils.getFileList("e:/old");
        if(fileList!=null)
        {
            for(int i=0;i<fileList.length;i++)
            {

                //判断文件是否是文件
                if (fileList[i].isFile()){
                    //文件名称去掉后缀
                    String realName = fileList[i].getName().substring(0, fileList[i].getName().lastIndexOf("."));
                    //数据库查找是否有此企业

                    if (true){
                        //获取分组名称
                        String groupName = "1";
                        // 如果文件夹不存在，则建立新文件夹
                        (new File("e:/new/"+groupName)).mkdirs();
                        FileUtils.copyFile(fileList[i],"e:/new/"+groupName+"/");
                    }

                }
                //判断文件是否是文件夹
                if (fileList[i].isDirectory()){
                    //数据库查找是否有此企业
                    if (true){
                        //获取分组名称
                        String groupName = "2";
                        // 如果文件夹不存在，则建立新文件夹
                        (new File("e:/new/"+groupName)).mkdirs();
                        FileUtils.copyFolder("e:/old/"+fileList[i].getName(), "e:/new/"+groupName+"/"+fileList[i].getName());
                    }

                }
                //企业名称
                String name = fileList[i].getName();
                System.out.println(name);
            }
        }


    }

    @Test
    public void test(){
        // 如果文件夹不存在，则建立新文件夹
        (new File("e:/old1")).mkdirs();
    }

}
