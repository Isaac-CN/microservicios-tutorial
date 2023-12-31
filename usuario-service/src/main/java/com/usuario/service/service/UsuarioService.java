package com.usuario.service.service;

import com.usuario.service.entity.Usuario;
import com.usuario.service.models.Carro;
import com.usuario.service.models.Moto;
import com.usuario.service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;
//Estamos indicando que con getForObject vamos a obtener algo, en este caso una lista de carros de un usuario en particular.
    public List<Carro> getCarros(int usuarioId){
        List<Carro> carros = restTemplate.getForObject("http://localhost:8002/carro/usuario/" + usuarioId, List.class);
        return carros;
    }
    //Estamos indicando que con getForObject vamos a obtener algo, en este caso una lista de carros de un usuario en particular.
    public List<Moto> getMotos(int usuarioId){
        List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId, List.class);
        return motos;
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario){
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return nuevoUsuario;
    }
}
