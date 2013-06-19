/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.test.sample.controller;

import java.util.logging.Logger;

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

   Logger logger = Logger.getLogger(LogController.class.getName());

   @Inject
   @TwilioRequestParams
   TwilioRequestMap twilioRequestMap;

   public void creditPayment(@Observes TwimlEvent event)
   {
      logger.info(event.getTwimlFormatted());

   }

   public void log()
   {
      logger.info(twilioRequestMap.toString());
   }
}
