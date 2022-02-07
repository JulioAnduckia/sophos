import { CustomerDto } from "../../customers/models/CustomerDto";

export interface AccountDto {
    customer: CustomerDto| null;
    accountNum: number;
    accountType: string;
    state: string | undefined;
    balance: number;
}