import React, { useState } from 'react';
import '../css/Register.css'; 
import fundo from '../img/fond.jpg'; 
import logo_s from '../img/logo_s.png'; 

import { useNavigate } from 'react-router-dom'; 
function Register() {

  const navigate = useNavigate();
  const [form, setForm] = useState({
    nome: '',
    email: '',
    senha: ''
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setForm({
      ...form,
      [name]: value
    });
  };



  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(form);
    navigate('/loginadmin'); 
  };

  const handleCancel = () => {
    navigate('/otherpage'); 
  };


  return (
    <div 
        className="register-container"
        style={{ backgroundImage: `url(${fundo})` }} 
        >
      <div className='left'>
        <form onSubmit={handleSubmit} className="register-form">
            <h2 className='Title'>REGISTER</h2>
            <p className="label">Nome:</p>
            <div className="input-group">
              <input 
                type="text" 
                name="nome" 
                value={form.nome} 
                onChange={handleInputChange} 
                placeholder="Nome"
                required 
              />
            </div>
            <p className="label">Mail:</p>
            <div className="input-group">
              <input 
                type="email" 
                name="email" 
                value={form.email} 
                onChange={handleInputChange} 
                placeholder="Mail"
                required 
              />
            </div>
            <p className="label">Senha:</p>
            <div className="input-group">
              <input 
                type="password" 
                name="senha" 
                value={form.senha} 
                onChange={handleInputChange} 
                placeholder="Senha"
                required 
              />
            </div>
            <div className="form-actions">
              <button type="submit" className="btn btn-success">Registrar</button>
              <button type="button" className="btn btn-cancel" onClick={handleCancel}>Cancel</button>
            </div>
        </form>
      </div>
      <div className='right'>
      <div className="register-logo">
          <img src={logo_s} alt="Logo" className="logo-style" />
      </div>

      </div>
    </div>
  );
}

export default Register;
