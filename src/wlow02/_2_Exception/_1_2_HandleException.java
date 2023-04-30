package wlow02._2_Exception;

// 捕获并处理异常
public class _1_2_HandleException {
    public static void main(String[] args) {
        // 以算数异常ArithmeticException为例
        try {
            System.out.println(10 / 0);
            /*此处产生异常, 程序就会在这里创建一个异常对象
            * --> new ArithmeticException();
            * 然后拿着这个对象到catch的小括号中逐个匹配
            * 如果匹配一致, 该异常就被捕获, 执行对应的catch的代码块
            * 然后就跳出try-catch体系继续执行其他语句
            * */
            System.out.println("不会执行到这里");
        }catch (ArithmeticException e){
            System.out.println("产生算数异常!");
            System.out.println(
                    e + "\n" + // java.lang.ArithmeticException: / by zero
                    e.getMessage() // / by zero
            );
            // 让多种异常匹配到相同的处理方案: 异常1 | 异常2 | 异常3.... , 不能用||
        }catch (ArrayIndexOutOfBoundsException /*| ArithmeticException*/ e){
            System.out.println("产生索引越界异常!");
        }catch (NullPointerException e){
            System.out.println("空指针异常!");
        }

        // catch成功捕获异常后就跳出try-catch体系继续执行下面的语句.
        System.out.println("catch成功的话就能执行到这里");
    }
}
