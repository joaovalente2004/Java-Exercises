package org.academiadecodigo.bootcamp;

public enum AccountType {
    SAVINGACCOUNT(1),
    CHECKINGACCOUNT(2);


private int id;

        AccountType(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public static AccountType get(int id) {
            for (AccountType accountType : values()) {
                if (accountType.getId() == id) {
                    return accountType;
                }
            }
            return null;
        }



}

