package com.oldlie.common.utils.accountcreator;

/**
 * @author OLDLIE
 * @date 2020/10/16
 */
public class AccountCreatorApplication {

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
}
