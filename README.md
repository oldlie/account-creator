# 批量创建账号信息的工具

示例：
```
    public static void main(String[] args) {
        AccountCreator accountCreator = AccountCreator.getInstance();
        for (int i = 0; i < 10; i++) {
            String en = accountCreator.getEnName();
            String cn = accountCreator.getFirstName() + accountCreator.getSecondName();
            System.out.println("Username:" + accountCreator.getEnName() +
                    ";Nickname:" + cn +
                    ";Phone:" + accountCreator.getMobile() +
                    ";Email:" + accountCreator.getEmail(en, true) +
                    ";Email:" + accountCreator.getEmail(cn, false) +
                    ";Ip:" + accountCreator.getIp());
        }
    }
```

运行结果：
```
Connected to the target VM, address: '127.0.0.1:55373', transport: 'socket'
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Username:stolte;Nickname:管煜;Phone:( 86 ) 15208909199;Email:11599279@qq.com;Email:guanyu@sina.com;Ip:227.137.184.189
Username:saber;Nickname:闵善彬;Phone:( 86 ) 18780646613;Email:okeke_71438@sina.com;Email:38509041@qq.com;Ip:33.3.96.238
Username:romona;Nickname:龚翰波;Phone:( 86 ) 18283583978;Email:alexandrou@sina.com;Email:gonghanbo@163.com;Ip:153.1.110.208
Username:tua;Nickname:龚婵臻;Phone:( 86 ) 18988513853;Email:brigitte_8@163.com;Email:gongchanzhen_138956@sina.com;Ip:152.244.76.97
Username:ocampo;Nickname:蔡舒琦;Phone:( 86 ) 13372422012;Email:hunt_1903710@hotmail.com;Email:94852585@qq.com;Ip:136.157.51.215
Username:hollie;Nickname:宋梓沛;Phone:( 86 ) 15030416671;Email:shea_31615@icloud.com;Email:songzipei@163.com;Ip:233.96.201.140
Username:pinion;Nickname:房桐;Phone:( 86 ) 13267119014;Email:culberson1@hotmail.com;Email:fangtong@hotmail.com;Ip:178.42.75.203
Username:rom;Nickname:辛超;Phone:( 86 ) 13556612833;Email:18205903@qq.com;Email:xinchao_944@sina.com;Ip:151.141.23.17
Username:kuhn;Nickname:李灿钰;Phone:( 86 ) 18680398247;Email:61424510@qq.com;Email:licanyu9357964@icloud.com;Ip:219.160.25.187
Username:ferdous;Nickname:鲍胜涵;Phone:( 86 ) 13692928753;Email:86949817@qq.com;Email:baoshenghan79137@163.com;Ip:186.212.145.189
Disconnected from the target VM, address: '127.0.0.1:55373', transport: 'socket'

Process finished with exit code 0
```

[中英文姓名语料](https://github.com/wainshine/Chinese-Names-Corpus)

[处理Excel](https://github.com/alibaba/easyexcel)

[中文转拼音](https://github.com/luhuiguo/chinese-utils)