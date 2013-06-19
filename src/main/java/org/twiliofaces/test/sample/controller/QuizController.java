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

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.annotations.notification.CallSid;
import org.twiliofaces.annotations.notification.Digits;
import org.twiliofaces.annotations.notification.From;
import org.twiliofaces.annotations.notification.RecordingUrl;
import org.twiliofaces.annotations.scope.TwilioScope;
import org.twiliofaces.test.sample.model.Caller;

@TwilioScope
@Named
public class QuizController implements Serializable
{

   private static final long serialVersionUID = 1L;

   Logger logger = Logger.getLogger(QuizController.class.getName());

   @Inject
   @CallSid
   String callSid;

   @Inject
   @From
   Instance<String> from;

   @Inject
   @RecordingUrl
   Instance<String> recordingUrl;

   @Inject
   @Digits
   Instance<String> digits;

   private Caller caller;

   int count = 0;

   public QuizController()
   {
   }

   public void first()
   {
      count++;
      logger.info("CALL SID: " + callSid + " count: " + count);
      logger.info("from number:" + from.get());
      this.caller = new Caller(from.get());
   }

   public void second()
   {
      count++;
      logger.info("CALL SID: " + callSid + " count: " + count);
      logger.info("recording url: " + recordingUrl.get());
      this.caller.setRecordingUrl(recordingUrl.get());
   }

   public void third()
   {
      count++;
      logger.info("CALL SID: " + callSid + " count: " + count);
      logger.info("digits: " + digits.get());
   }

   public String getIntro()
   {
      return "What's your name?";

   }

   public String getHangoutMessage()
   {
      return "Hey, you don't want play with me! Bye bye";
   }

   public String getQuestion()
   {
      return "What's the name of Italy capital? Click 1 for Rome, click 2 for Milan, click 3 for Venice.";

   }

   public String getResult()
   {
      if (digits != null && digits.get() != null && !digits.get().isEmpty() && digits.get().trim().equals("1"))
      {
         return "Awesome! your answer is correct";
      }
      return "Nooo! You must to go in Italy!! Rome is the Italy's capital!";

   }

   public Caller getCaller()
   {
      return caller;
   }

   public void setCaller(Caller caller)
   {
      this.caller = caller;
   }

}