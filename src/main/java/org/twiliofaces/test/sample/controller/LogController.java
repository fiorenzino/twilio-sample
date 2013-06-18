package org.twiliofaces.test.sample.controller;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.annotations.TwilioRequestParams;
import org.twiliofaces.api.event.TwimlEvent;
import org.twiliofaces.request.pojo.TwilioRequestMap;

@Named
@RequestScoped
public class LogController
{

   @Inject
   @TwilioRequestParams
   TwilioRequestMap twilioRequestMap;

   public void creditPayment(@Observes TwimlEvent event)
   {
      System.out.println(event.getTwimlFormatted());

   }

   public void log()
   {
      System.out.println(twilioRequestMap.toString());
   }
}
