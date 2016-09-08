# JavaBase
Java基础

1.面向对象三大特征：封装、继承、多态

2.多态三个前提：继承、重写、父类引用指向子类对象
  多态优点：提高程序的扩展性
  多态缺点：父类引用只能访问父类中已有的方法，不可访问子类的方法
  
3.抽象类和接口的异同
  同：都不能够实例化
  异：抽象类中可以定义构造方器，可以有抽象方法和具体方法；接口不能定义构造器，接口中的方法全部为抽象方法
      抽象类中的成员可以是private、默认、protected、public；接口中的成员全部为public
      抽象类可以定义成员变量；接口中只能定义常量
      有抽象方法的类必须声明为抽象类，抽象类中不一定有抽象方法
      
4.集合
 
                                               |---ArrayList底层是数组结构，查询快、增删慢，不同步
            |---List(有序、元素可重复、有索引) |---LinkedList底层是链表结构，增删快、查询慢，不同步
            |                                  |---Vector底层是数组结构，线程同步，已被ArrayList取代
  Collection|
            |                                  |---HashSet底层是哈希表、无序、线程不同步、高效
            |---Set(无序、元素不可重复、无索引)| 
                                               |---TreeSet底层是二叉树、可对元素进行排序，默认是自然顺序
                                               
            |---HashMap底层是哈希表结构、允许使用null键和null值、不同步、效率高
         Map|---HashTable底层是哈希表结构、不可存入null键和null值、同步
            |---TreeMap底层是二叉树、可排序、不同步
  
5.IO流

  字节流：InputStream、OutputStream
  
  字符流：Reader、Writer
  
          Reader:读取字符流的抽象类
          
          BufferedReader:将字符存入缓冲区，再读取
          
          LineNumberReader:带行号的字符缓冲输入流
          
          InputStreamReader:转换流，字节流和字符流的桥梁，多在编码的地方使用
          
          FileReader:读取字符文件的便捷类
          
          Writer:写入字符流的抽象类
          
          BufferedWriter:将字符存入缓冲区，再写入
          
          OutputStreamWriter:转换流，字节流和字符流的桥梁，多在编码的地方使用
          
          FileWriter:写入字符文件的便捷类
          
InputStream:字节输入流的所有类的超类

     ByteArrayInputStream:含缓冲数组，读取内存中字节数组的数据，未涉及流
     
     FileInputStream:从文件中获取输入字节
     
     BufferedInputStream：带有缓冲区的字节输入流
     
		 DataInputStream：数据输入流，读取基本数据类型的数据
		 
	   ObjectInputStream：用于读取对象的输入流
	   
     PipedInputStream：管道流，线程间通信，与PipedOutputStream配合使用
     
	   SequenceInputStream：合并流，将多个输入流逻辑串联。
	   
OutputStream：此抽象类是表示输出字节流的所有类的超类

	   ByteArrayOutputStream：含缓冲数组，将数据写入内存中的字节数组，未涉及流
	   
	   FileOutputStream：文件输出流，将数据写入文件
	   
	   BufferedOutputStream：带有缓冲区的字节输出流
	   
		 PrintStream：打印流，作为输出打印
		 
		 DataOutputStream：数据输出流，写入基本数据类型的数据
		 
	   ObjectOutputStream：用于写入对象的输出流
	   
	   PipedOutputStream：管道流，线程间通信，与PipedInputStream配合使用
	   
6.多线程

 进程和线程的区别：
 
  1.进程是静态的，是指开启的一个程序，线程是动态的，是真正的执行单元
  
  2.同样作为基本的执行单元，线程是比进程划分更小的执行单元
  
  3.每个进程都有一段专用的内存区域，线程确是共享内存单元
  
 线程创建方式：
 
 1.继承Thread
 
  1)定义一个类继承Thread
  
  2)重写run方法
  
  3)创建Thread子类对象并调用start方法
  
 2.实现Runnale接口
  
  1)定义类实现Runnale接口
  
  2)实现run方法
  
  3)创建Runnale实现类对象
  
  4)传入Runnale实现类对象创建Thread类对象并调用start方法
  
 两种创建线程的区别：
 
  继承方式：执行代码放在Thread子类的run方法中
 
  实现方式：线程存放在实现Runnale接口的类的run方法中，避免单继承局限性，建议使用
 
 线程状态
 
  新建状态：start()
  
  临时状态：具备cpu的执行资格，但无执行权
  
  运行状态：具备cpu执行权，可执行
  
  冻结状态：通过sleep或wait使线程不具备执行资格，需要notify唤醒，并处于临时状态
  
  消亡状态：run方法执行完或者线程中断，使得线程死亡
  
 多线程安全问题
 
  多线程共享同一数据，当某一线程执行多条语句时，其他线程也执行进来，导致数据在某条语句中被多次修改，执行到下一条语句时，导致错误数据的产生
  
  因素：多个线程操作共享数据；多条语句操作同一数据
  
  原理：同一时间只让一个线程执行完操作共享数据的所有语句
  
  办法：使用锁机制，synchronized或lock对象
  
 线程同步
 
  当两个或两个以上的线程需要共享资源，他们需要某种方法来确定资源在某一刻仅被一个线程占用，达到此目的的过程叫做同步（synchronization）
  
  同步代码块：synchronized(对象){}，将需要同步的代码放在大括号中，括号中的对象即为锁。
  
  同步函数：放于函数上，修饰符之后，返回类型之前。
  
 wait和sleep的区别：（执行权和锁区分）
 
  wait：可指定等待的时间，不指定须由notify或notifyAll唤醒、线程会释放执行权，且释放锁。
  
  sleep：必须制定睡眠的时间，时间到了自动处于临时（阻塞）状态、即使睡眠了，仍持有锁，不会释放执行权。
  
  














