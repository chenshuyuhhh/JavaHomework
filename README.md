## com.chenshuyusc.hw3
`Doing word frequency statistics`

### Core Classes Introduction
#### 1. 可读或者写的父类
>一个可读或者写的父类 `FileReadorWrite`
根据其子类实现的接口决定子类是读还是写
内部有文件和文件格式作为成员变量
文件就是其执行相关操作的文件

#### 2. 读 & 写接口
>`IReading`: 几种读取文件的方法，以字节、字符、行、全部等方式读取
>`Iwriting`: I/O 写操作的方法，以字节、字符、行、全部等方式写

#### 3. 读 & 写具体实现类
>`FileRead`: 可用来读的类，不同的读方式有不同的实现方式
>`FileWrite`：实现文件写操作接口，不同的写的方式，有不同的实现方法

####  4. SortByValueMap 类
>类似于装饰模式
>`SortByValueMap` 是一个实现了按值排序的 map
>有降序和升序的排序方法
>内部是一个 TreeMap
>同时内部有 List<Map.Entry<String, Integer>> list，存放排序后的 map 键值对
>有将 list 转换成 String 字符串的方法，便于展示排序结果

#### 5.Main 类
>有整个程序的入口方法  public static void main(String[] args){...}
并有处理读取数据的静态方法和统计词频的方法


### How to use
> Find main function of the project and run,then you can find the output file in output directory!