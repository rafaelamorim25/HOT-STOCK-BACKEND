package com.rafaelamorim.arquiteturaspring.testes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.Id;

import com.rafaelamorim.arquiteturaspring.domain.Categoria;

public class TesteAnotacao {

	public static void main(String[] args) {
		Categoria c = new Categoria(1, "teste");
		
		Field[] fields = c.getClass().getDeclaredFields();
		
		String nomeAtributo = "";
		
		for (Field field : fields) {
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				if(annotation instanceof Id) {
					nomeAtributo = field.getName();
				}
			}
		}
		
		String nomeMetodo = "get" + nomeAtributo.substring(0,1).toUpperCase() + nomeAtributo.substring(1);
		
		System.out.println(nomeMetodo);
		
		try {
			Method m = c.getClass().getMethod(nomeMetodo, new Class[] {});
			
			Integer ret = (Integer) m.invoke(c, new Object[] {});
			
			System.out.println(ret);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
