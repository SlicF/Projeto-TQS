import React, { useState } from 'react';
import '../../css/Administration/loginAdmin.css';
import logo_s from '../../img/logo_s.png';

import { useNavigate } from 'react-router-dom';
import Navbar from '../../components/NavbarAdmin';

function Login() {
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
        navigate('/adminHome');
    };


    return (
        <div>
            <Navbar />
            <h2 className='Title'>Login</h2>
            <div className="login-container">

                <div className='left'>
                    <form onSubmit={handleSubmit} className="login-form">
                        <div className="input-group">
                            <p className="label">Nome:</p>
                            <input
                                type="text"
                                name="nome"
                                value={form.nome}
                                onChange={handleInputChange}
                                placeholder="Nome"
                                required
                            />
                        </div>
                        <div className="input-group">
                            <p className="label">Mail:</p>
                            <input
                                type="email"
                                name="email"
                                value={form.email}
                                onChange={handleInputChange}
                                placeholder="Mail"
                                required
                            />
                        </div>
                        <div className="input-group">
                            <p className="label">Senha:</p>
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
                            <button type="submit" className="btn btn-success">Login</button>
                            <button type="button" className="btn btn-cancel">Cancel</button>
                        </div>
                    </form>
                </div>
                <div className='right'>
                    <div className="login-logo">
                        <img src={logo_s} alt="Logo" />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;
