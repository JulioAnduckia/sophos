export interface GeneralResponse<T> {
    data: T ;
    success: boolean;
    message: string;
    resp: string;
    code: number;
}