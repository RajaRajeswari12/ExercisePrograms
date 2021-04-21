package com.example.javabasic;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChildPredicate {
public static Predicate<child> filterByAge(int x){
	return a->a.getAge() > x;
}

static List<child> filterChilds(List<child> childs,Predicate<child> predicate){
	return childs.stream().filter(predicate).collect(Collectors.<child> toList());
}
}
