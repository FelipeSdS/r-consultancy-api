package br.com.rconsultancy.dto.cliente;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public abstract class ClienteAbstractDTO {

	@NotBlank(message = "Razão Social é obrigatorio ser informada.")
    private String txRazaoSocial;
    
    private String txNomeFantasia;
    
    private String txNomeSimples; 
    
    private String txCpf; 
    
    private String txCnpj; 
    
    private String txCep; 
    
    private String txLogradouro; 
    
    private Long vlNumero; 
    
    private String txBairro; 
    
    private String txComplemento; 
    
    private String txCidade; 
    
    private String txUf; 
    
    private String txPais; 
    
    private String txTelefone; 
    
    private String txEmail; 
    
    private String txWebSite;
    
    private String txAreaNegocios;  
}
