# JavaccGrammar
## 概述
使用JavaCC的模板文件对CMM语言的词法、语法、语义分析进行编写，并自动生成。<br>
### 词法部分
类型：int \ real \ string<br>
关键字：if \ else \ while \ for \ read \ write \ int \ real \ void \ char \ return<br>
操作符：+  - * /  =  <  >  <=  >= == <><br>
### 语法部分
实现if语句、while语句、for语句、read语句、write语句、声明语句、函数声明语句、函数调用语句、赋值语句、返回语句<br>
### 语义部分
检查不同类型之间的是否可以进行运算和比较；<br>
检查除数不能为0；<br>
检查变量是否声明；<br>
检查函数是否声明；<br>
检查变量是否重复声明；<br>
检查函数是否重复定义；<br>
检查赋值时类型是否正确；<br>


## 模板文件的内容构成
模板文件主要包括四个部分。<br>
### options
该部分可以对javacc进行相关的配置设置，由于需要进行函数声明与调用，这里我将LOOKAHEAD的值设置为3，为了更好地进行二义性区分。<br>
### CMMParser主类部分
编写主函数入口，设置输入输出流。<br>
### TOKEN部分
设置保留字、使用正则表达式定义数字和字符串、设置一些符号<br>
### 语法语义部分
写递归下降的语法分析，并在其中设置语义分析<br>