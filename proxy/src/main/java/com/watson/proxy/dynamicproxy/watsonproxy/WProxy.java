package com.watson.proxy.dynamicproxy.watsonproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class WProxy {
    private static final String LN = "\r\n";
    public static Object newProxyInstance(WClassLoader classLoader,Class<?>[] interfaces,WInvocationHandler h){
        //1.生成源文件
        String src = generateSrc(interfaces);
        String filePath = WProxy.class.getResource("").getPath();
        System.out.println(src);
        //2.动态编译
        File f = new File(filePath+"$Proxy0.class");
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
        Iterable iterable = manager.getJavaFileObjects(f);
        JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,null);
        task.call();
        try {
            manager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.保存


        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        //大概就是这么个意思，没有写完整
        StringBuffer sb = new StringBuffer();
        sb.append("package com.watson.proxy.dynamicproxy.watsonproxy.WProxy"+LN)
                .append("import java.lang.reflect.*;"+LN)
                .append("import com.watson.proxy.Person;"+LN)
                .append("public final class $WProxy0 extends WProxy implements "+interfaces[0].getName()+"{"+LN)
                .append("   public $WProxy0(WInvocationHandler h){"+LN)
                .append("       this.h = h;"+LN)
                .append("   }"+LN);
        for(Method m:interfaces[0].getMethods()){
            sb.append("public "+m.getReturnType()+" "+m.getName()+"(){"+LN);
            sb.append("}");
        }

                sb.append("}"+LN);
        return sb.toString();
    }
}
