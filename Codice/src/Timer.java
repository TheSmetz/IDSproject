public class Timer {
   private final int timerBocchetta = 10;
   private final int timerOperazione = 20;
   private boolean sessione = false;

   public Timer(){} //costruttore

   private void startTimerBocchetta(){}
   private void startTimerOperazione(){}
   private void startSessione(){}
   private void ripristinoSessione(){}
   public void notifyTimerSessione(){}

   public boolean isSessione() {
      return sessione;
   }

   public int getTimerBocchetta() {
      return timerBocchetta;
   }

   public int getTimerOperazione() {
      return timerOperazione;
   }

   public void setSessione(boolean sessione) {
      this.sessione = sessione;
   }
}
