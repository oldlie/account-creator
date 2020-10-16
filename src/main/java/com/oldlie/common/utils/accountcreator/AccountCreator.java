package com.oldlie.common.utils.accountcreator;

import com.alibaba.excel.EasyExcel;
import com.luhuiguo.chinese.ChineseUtils;
import com.luhuiguo.chinese.pinyin.CaseType;
import com.luhuiguo.chinese.pinyin.PinyinFormat;
import com.luhuiguo.chinese.pinyin.ToneType;
import com.luhuiguo.chinese.pinyin.YuCharType;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

/**
 * @author OLDLIE
 * @date 2020/10/16
 */
public class AccountCreator {

    public Random random;

    public AccountCreator() {
        this.random = new Random();
    }

    private static AccountCreator accountCreator;

    public static AccountCreator getInstance() {
        return getInstance(true);
    }

    public static AccountCreator getInstance(boolean refresh) {
        if (refresh || accountCreator == null) {
            accountCreator = new AccountCreator();
        }
        return accountCreator;
    }

    private List<String> firstNameList;
    private List<String> secondNameList;
    private List<String> enNameList;

    public String getFirstName () {
        if (firstNameList == null) {
            InputStream in = this.getClass().getResourceAsStream("/cfn.xlsx");
            NameListener listener = new NameListener();
            EasyExcel.read(in, Name.class, listener).sheet().doRead();
            this.firstNameList = listener.getNameList();
        }
        int bound = this.firstNameList.size() - 1;
        if (bound < 0) {
            throw new RuntimeException("get first name cn bound run time exception");
        }
        Random random = new Random();
        int index = random.nextInt(bound);
        return this.firstNameList.get(index);
    }

    public String getSecondName() {
        if (this.secondNameList == null) {
            InputStream in = this.getClass().getResourceAsStream("/csn.xlsx");
            NameListener listener = new NameListener();
            EasyExcel.read(in, Name.class, listener).sheet().doRead();
            this.secondNameList = listener.getNameList();
        }
        int nameLength = new Random().nextInt(2) + 1;
        String name = "";
        int bound = this.secondNameList.size() - 1;
        if (bound < 0) {
            throw new RuntimeException("get first name cn bound run time exception");
        }
        for (int i = 1; i <=nameLength; i++) {
            Random random = new Random();
            int index = random.nextInt(bound);
            String temp = this.secondNameList.get(index);
            if (temp == "") {
                System.out.println("index=>" +index);
            }
            name += this.secondNameList.get(index);
        }
        return name;
    }

    public String getEnName () {
        if (this.enNameList == null) {
            InputStream in = this.getClass().getResourceAsStream("/en.xlsx");
            NameListener listener = new NameListener();
            EasyExcel.read(in, Name.class, listener).sheet().doRead();
            this.enNameList = listener.getNameList();
        }
        int bound = this.enNameList.size() - 1;
        if (bound < 0) {
            throw new RuntimeException("get english name en bound run time exception");
        }
        Random random = new Random();
        int index = random.nextInt(bound);
        return this.enNameList.get(index);
    }

    public String getMobile () {
        String[] ns = new String[] {
                "3","5","7","8"
        };
        int r2 = this.random.nextInt(4);
        return  "( 86 ) 1" + ns[r2] + build3to11();
    }

    private String build3to11 () {
        int max = 8;
        StringBuilder builder = new StringBuilder(max);
        for (int i = 0; i <= max; i++) {
            builder.append(this.random.nextInt(10));
        }
        return builder.toString();
    }

    public static String[] EmailCompany = new String[] {
            "@qq.com","@163.com","@sina.com","@icloud.com","@hotmail.com"
    };

    public String getEmail(String username, boolean isEn) {
        int ec = this.random.nextInt(5);
        StringBuilder builder = new StringBuilder(128);
        if (ec == 0) {
            // qq邮箱7-9位数字第一位不为0
            int mal = this.random.nextInt(1) + 7;
            builder.append(this.random.nextInt(9) + 1);
            for (int i = 0; i < mal; i++) {
                builder.append(this.random.nextInt(10));
            }
        } else {
            // 其他邮箱有英文加字幕组成，英文至少2字符
            if (isEn) {
                builder.append(username);
            } else {
                builder.append(ChineseUtils.toPinyin(username,
                        new PinyinFormat(YuCharType.WITH_V,
                                ToneType.WITHOUT_TONE,
                                CaseType.LOWERCASE,
                                "",
                                true
                        ))
                );
            }
            int nl = this.random.nextInt(8);
            if (nl > 0) {
                int sl = this.random.nextInt(2);
                if (sl == 1) {
                    builder.append("_");
                }
            }
            for (int i = 0; i < nl; i++) {
                builder.append(this.random.nextInt(10));
            }
        }
        return builder.append(EmailCompany[ec]).toString();
    }

    public String getIp() {
        this.random = new Random();
        return (this.random.nextInt(255) + 1) + "." +
                (this.random.nextInt(256)) + "." +
                (this.random.nextInt(256)) + "." +
                (this.random.nextInt(256));
    }

}
