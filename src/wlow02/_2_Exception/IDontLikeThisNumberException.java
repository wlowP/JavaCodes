package wlow02._2_Exception;

// 运行时异常(参数错误)-> 继承RuntimeException; 编译时异常-> 继承Exception
public class IDontLikeThisNumberException extends RuntimeException{
    public IDontLikeThisNumberException() {
    }

    public IDontLikeThisNumberException(String message) {
        super(message);
    }
}
