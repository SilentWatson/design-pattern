package com.watson.proxy.dynamicproxy.watsonproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class WatsonClassLoader extends ClassLoader{

    private File classPathFile;
    public WatsonClassLoader(){
        String classPath = WatsonClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = WatsonClassLoader.class.getPackage().getName()+"."+name;
        if(classPathFile!=null){
            File classFile = new File(classPathFile,name.replaceAll("\\.", "/"+".class"));
            if(classFile.exists()){
                FileInputStream fis = null;
                ByteArrayOutputStream baos = null;
                try{
                    fis = new FileInputStream(classFile);
                    baos = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len=fis.read(buff))!=-1){
                        baos.write(buff,0,len);
                    }
                    return defineClass(className,baos.toByteArray(),0, baos.size());

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
