package com.company;

public class Account
{
    private String id;
    private String password;

    private AccountStatus status;

    public Account(String id, String password)
    {
        this.id = id;
        this.password = password;
        status = AccountStatus.ACTIVE;
    }

    @Override
    public boolean equals(Object other)
    {
        Account otherAccount = (Account) other;
        return this.id.equals(otherAccount.id) && this.password.equals(otherAccount.password)
                && this.status == otherAccount.status;
    }

    public boolean resetPassword(String password, String id)
    {
        if(status == AccountStatus.ACTIVE && id.equals(this.id))
        {
            this.password = password;
            return true;
        }
        return false;
    }
}
