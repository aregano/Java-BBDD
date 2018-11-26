package com.alvaro.models;

public class Operador {
	
	public int suma(int a, int b){
		return a+b;
	}

	public int sumaAbs(int a, int b) {
		
		int res = a+b;
		if(res<0) res = -res;
		
		return res;
		
		
//		if(a<0 && b<0) {
//			int aneg = -a;
//			int bneg = -b;
//			int suma = aneg+bneg;
//			return suma;
//		}
//		
//		if(b<0) {
//			int bneg = -b;
//			int suma = bneg + a;
//			return suma;
//			}
//		
//		if(a<0) {
//			int aneg = -a;
//			int suma = aneg +b;
//			return suma;
//		}else {
//			int suma = a+b;
//			return suma;
//		
//		}
		
	}
}
