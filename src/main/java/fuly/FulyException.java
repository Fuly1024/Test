package fuly;

public class FulyException extends Exception {

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	//构造函数
	public FulyException(){
		super();
	}
	
	public FulyException(String string){
		super(string);
	}
	
	public FulyException(String string,Throwable throwable){
		super(string,throwable);
	}
}
