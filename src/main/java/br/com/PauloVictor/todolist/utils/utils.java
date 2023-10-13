package br.com.PauloVictor.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class utils {

    
    public static void copyNunNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }


    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source); //é uma forma de acessar as propriedades de um objeto e o impl é a implementação dessa interface

        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for(PropertyDescriptor pd:pds) {
           Object srcValue = src.getPropertyValue(pd.getName());
           if(srcValue == null) {
            emptyNames.add(pd.getName());
           }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
