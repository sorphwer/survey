package mg.studio.android.survey;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
/**
 *
 * This class is not used in this version
 */
public class FileService {
    static public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    static public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
    /**
    static public void showDir(FileService fs){

        if(isExternalStorageWritable()&&isExternalStorageReadable()){
            //internal
            //https://developer.android.com/training/data-storage/files/internal?hl=zh-cn
            //2020-02-29 15:13:55.492 1659-1659/mg.studio.android.survey I/Internal Dir: file_dir=/data/user/0/mg.studio.android.survey/files
            File filesDir = getFilesDir();
            Log.i("Internal Dir","file_dir="+filesDir);

            //external
            //https://developer.android.com/training/data-storage/files/external?hl=zh-cn#java
            //2020-02-29 15:13:55.525 1659-1659/mg.studio.android.survey I/External: externalFileDir = /storage/emulated/0/Android/data/mg.studio.android.survey/files
            //2020-02-29 15:13:55.531 1659-1659/mg.studio.android.survey I/ExternalCustom: externalFileDir = /storage/emulated/0/Android/data/mg.studio.android.survey/files/Reports
            File externalFilesDir = getExternalFilesDir(null);
            Log.i("External", "externalFileDir = "+externalFilesDir);

            File externalFilesDirCustom = getExternalFilesDir("Reports");
            Log.i("ExternalCustom", "externalFileDir = "+externalFilesDirCustom);
        }
        else{
            Log.e("File","External Storage Unavailable");
        }

    }
     **/
    //static method
    static public void SaveToSD(String name, String content,File file)throws Exception{
        //Environment.getExternalStorageDirectory()

        //File file=new File(Environment.getExternalStorageDirectory(),name);
        Environment.getExternalStorageDirectory();
        FileOutputStream outStream=new FileOutputStream(file);
        //写入文件
        outStream.write(content.getBytes());
        outStream.close();
    }
}
