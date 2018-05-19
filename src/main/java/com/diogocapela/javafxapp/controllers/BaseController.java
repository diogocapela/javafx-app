package com.diogocapela.javafxapp.controllers;

import com.diogocapela.javafxapp.utils.Logger;
import com.diogocapela.javafxapp.models.Empresa;

abstract class BaseController {

    Empresa empresa;

    public BaseController() {
        Logger.log("BaseController: BaseController()");
        empresa = Empresa.getInstance();
    }

}