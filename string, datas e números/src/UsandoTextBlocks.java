
public class UsandoTextBlocks {

	public static void main(String[] args) {

		String strSemTextBlock = "<html>\n" + 
								"     <body>\n" +
								"         <p>Hello, world</p>\n" +
								"     </body>\n" +
								"<html>\n";
		
		System.out.println(strSemTextBlock);
		
		String strComTextBlock = """
				 	            <html>
				 				    <body>
				 				         <p>Hello, world</p>
				 				    </body>
				 				</html>
								""";
		
		System.out.println(strComTextBlock);
		
		String strComTextBlock2 = """
				<html>
					<body>
						<p>Hello, world</p>
					</body>
				</html>
				""";
		
		System.out.println(strComTextBlock2);
		
		System.out.println("""
			    This is the first line
			    This is the second line
			    This is the third line
			    """);
		
		System.out.println("""
			    This is the first line \
			    This is the second line \
			    This is the third line \
			    """);
		
		System.out.println("""
			    a    \s
			    bbbbb\s
			    c    \s
			    """);
	}
}
