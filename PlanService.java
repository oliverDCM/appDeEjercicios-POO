package proyectoFinal;

import proyectoFinal.PlanEjercicio;
import proyectoFinal.Usuario;
import proyectoFinal.Fits;

public class PlanService {

    public static PlanEjercicio generarPlan(Usuario usuario) {
        if (usuario == null || usuario.getDatosFitness() == null) {
            System.err.println("Error: No se pueden generar el plan sin datos de usuario o fitness.");
            return null;
        }

        Fits datos = usuario.getDatosFitness();
        String nivel = datos.getNivelActividad();
        String objetivo = normalizarObjetivo(datos.getObjetivo()); // CORRECCIÓN CLAVE: Normaliza el objetivo

        return switch (nivel + "|" + objetivo) {

            case "Sedentario|Déficit Calórico" -> new PlanDeficitSedentario(usuario);
            case "Ligero|Déficit Calórico" -> new PlanDeficitLigero(usuario);
            case "Moderado|Déficit Calórico" -> new PlanDeficitModerado(usuario);
            case "Activo|Déficit Calórico" -> new PlanDeficitActivo(usuario);

            case "Sedentario|Mantener Peso" -> new PlanMantenerPesoSedentario(usuario);
            case "Ligero|Mantener Peso" -> new PlanMantenerPesoLigero(usuario);
            case "Moderado|Mantener Peso" -> new PlanMantenerPesoModerado(usuario);
            case "Activo|Mantener Peso" -> new PlanMantenerPesoActivo(usuario);

            case "Sedentario|Subir Peso" -> new PlanSubirPesoSedentario(usuario);
            case "Ligero|Subir Peso" -> new PlanSubirPesoLigero(usuario);
            case "Moderado|Subir Peso" -> new PlanSubirPesoModerado(usuario);
            case "Activo|Subir Peso" -> new PlanSubirPesoActivo(usuario);

            case "Sedentario|Aumentar Masa Muscular" -> new PlanMasaSedentaria(usuario);
            case "Ligero|Aumentar Masa Muscular" -> new PlanMasaLigero(usuario);
            case "Moderado|Aumentar Masa Muscular" -> new PlanMasaModerado(usuario);
            case "Activo|Aumentar Masa Muscular" -> new PlanMasaActivo(usuario);

            default -> {
                System.err.println("No se encontró un plan específico para la combinación: " + nivel + " | " + objetivo);
                yield null;
            }
        };
    }

    private static String normalizarObjetivo(String objetivo) {
        if (objetivo == null) return "Desconocido"; // Evita NPE si el objetivo es nulo

        return switch (objetivo.toUpperCase()) {
            case "DC", "DEFICIT CALORICO" -> "Déficit Calórico";
            case "MP", "MANTENER PESO" -> "Mantener Peso";
            case "SP", "SUBIR PESO" -> "Subir Peso";
            case "AM", "AP", "AUMENTAR MASA MUSCULAR" -> "Aumentar Masa Muscular";
            default -> objetivo; // Devuelve el valor original si no es una abreviatura conocida
        };
    }
}