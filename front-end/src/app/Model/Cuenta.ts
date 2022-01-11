

export interface Cuenta {
    id: number;
    num_documento: number;
    tipo_cuenta: string;
    numero_cuenta: number;
    estado: String | undefined;
    saldo: number;
  
}