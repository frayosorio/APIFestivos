package apifestivos.apifestivos.controladores;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apifestivos.apifestivos.entidades.dtos.FestivoDto;
import apifestivos.apifestivos.interfaces.IFestivoServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/festivos")
@Api(value = "Operaciones Festivos", description = "Operaciones relacionadas con las fechas festivas en Colombia")
public class FestivoControlador {

    @Autowired
    private IFestivoServicio servicio;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/verificar/{año}/{mes}/{dia}", method = RequestMethod.GET)
    @ApiOperation(value = "Verificar si una fecha es festiva", response = String.class)
    public String verificarFestivo(@PathVariable int año, @PathVariable int mes, @PathVariable int dia) {
        // @RequestMapping(value = "/verificar", method = RequestMethod.GET)
        // public String verificarFestivo(@RequestParam("fecha") String textoFecha) {

        if (servicio.esFechaValida(String.valueOf(año) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia))) {

            // return servicio.esFestivo(fecha) ? strFecha + " es Festivo" : strFecha + " no
            // es festivo";
            Date fecha = new Date(año - 1900, mes - 1, dia);
            // return String.valueOf(fecha);
            return servicio.esFestivo(fecha) ? "Es Festivo" : "No es festivo";
        } else {
            return "Fecha No valida";
        }

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/obtener/{año}", method = RequestMethod.GET)
    @ApiOperation(value = "Listar los festivos de un año", response = Iterable.class)
    public List<FestivoDto> obtener(@PathVariable int año) {
        return servicio.obtenerFestivos(año);
    }

}
