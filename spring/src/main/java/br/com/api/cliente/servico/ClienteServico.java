package br.com.api.cliente.servico;

//import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.cliente.modelo.ClienteModelo;
import br.com.api.cliente.modelo.RespostaModelo;
import br.com.api.cliente.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {
    
    @Autowired
    private ClienteRepositorio cr;

    @Autowired
    private RespostaModelo rm;

    //Listar clientes
    public Iterable<ClienteModelo> listar(){
        return cr.findAll();
    }

    //Cadastro e Alteração de clientes
    public ResponseEntity<?> cadastrarAlterar(ClienteModelo cm, String acao){
        if(cm.getNome().equals("")){
            rm.setMensagem("O nome do cliente é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if (cm.getEmail().equals("")){
            rm.setMensagem("O e-mail é obrigatorio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if (cm.getCep().equals("")){
            rm.setMensagem("O CEP é obrigatorio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ClienteModelo>(cr.save(cm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ClienteModelo>(cr.save(cm), HttpStatus.OK);
            }
        }
    }

    //Remover clientes
    public ResponseEntity<RespostaModelo> remover(long codigo){
        cr.deleteById(codigo);
        rm.setMensagem("O cliente foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}
