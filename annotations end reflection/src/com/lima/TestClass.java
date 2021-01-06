package com.lima;

@ClassInfo(autor="rafa", data="04/01/2021")
public class TestClass implements Service {

	@Executar(arg = "A")
	public void m1(String param) {
		System.out.println("m1() => " + param);
	}
	
	public void m2(String param) {
		System.out.println("m2() => " + param);
	}
	
	@Executar(arg = "B")
	public void m3(String param) {
		System.out.println("m3() => " + param);
	}
	
	@Init(runOnInstantiation = true)
	public void m4() {
		System.out.println("m4()");
	}
	
	@Init(runOnInstantiation = false)
	public void m5() {
		System.out.println("m5");
	}
}
