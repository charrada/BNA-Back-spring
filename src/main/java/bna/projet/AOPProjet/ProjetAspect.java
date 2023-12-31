package bna.projet.AOPProjet;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ProjetAspect {


    @Before("execution(* bna.projet.Services.ProjetService.*(..))")
    public void logMethodServices(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Activation de la methode de   " + name + "  ");
    }
    @After("execution(* bna.projet.Services.PdfExport.*(..))")
    public void logMethodPdf(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Activation de l'export excel par la methode :  " + name + "  ");
    }
}
