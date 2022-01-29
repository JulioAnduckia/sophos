export interface Transfer{
    
    id: number;
    transferDate: Date;
    movementType: string;
    transferAccount: number;
    toTransfer: number;
    balance: number;
    documentNum: number,

}