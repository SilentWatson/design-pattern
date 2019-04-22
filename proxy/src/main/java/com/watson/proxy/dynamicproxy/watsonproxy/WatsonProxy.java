package com.watson.proxy.dynamicproxy.watsonproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class WatsonProxy {
    private static final String ln = "\r\n";
    public static Object newProxyInstance(WatsonClassLoader loader,
                                          Class<?>[] interfaces,
                                          WatsonInvocationHandler h)
            throws IllegalArgumentException{
        try{
            String src = generateSrc(interfaces);
            System.out.println(src);
            String filePath = WatsonProxy.class.getResource("").getPath();
            File f = new File(filePath+"$Proxy.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null,null, null, iterable);
            task.call();
            manager.close();
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(WatsonInvocationHandler.class);
            return  c.newInstance(h);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.watson.proxy.dynamicproxy.watsonproxy;"+ln);
        sb.append("import com.watson.proxy.staticproxy.IPerson;"+ln);
        sb.append("import java.lang.reflect.*;"+ln);
        sb.append("public class $Proxy0 implements "+interfaces[0].getName()+"{"+ln);

        sb.append("WatsonInvocationHandler h;"+ln);
        sb.append("public $Proxy0(WatsonInvocationHandler h){"+ln);
            sb.append("this.h = h;"+ln);
        sb.append("}"+ln);

        for(Method m: interfaces[0].getMethods()){
            sb.append("public "+m.getReturnType().getName()+" "+m.getName()+"(){"+ln);
            sb.append("try{"+ln);
                sb.append("Method m = "+interfaces[0].getName()+".class.getMethod(\""+m.getName()+"\", new Class[]{});");
                sb.append("this.h.invoke(this, m, null);"+ln);




            sb.append("}catch(Throwable e){"+ln);
                sb.append("e.printStackTrace();"+ln);
            sb.append("}"+ln);
            sb.append("}"+ln);
        }


        sb.append("}"+ln);

        return sb.toString();
    }
}
