package com.w.appbiblio;

import android.os.AsyncTask;

public class AsyncTaskLogin extends AsyncTask<Object, Void, Boolean> {

    private IComunicacion comunicacion;

    public AsyncTaskLogin(IComunicacion comunicacion) { this.comunicacion = comunicacion; }

    /**
     * @deprecated
     */
    @Override
    protected void onPreExecute() {
        comunicacion.toggleProgressBar(true);
    }

    /**
     * @param objects
     * @deprecated
     */
    @Override
    protected Boolean doInBackground(Object... objects) {
        try {
            Thread.sleep((int) objects[2]);
            String user = (String) objects[0];
            String pass = (String) objects[1];
            if (user.equals("admin") && pass.equals("admin")){
                return true;
            }else{
                return false;
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        return false;
    }

    /**
     * @param aBoolean
     * @deprecated
     */
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (aBoolean){
            this.comunicacion.lanzarActividad(gitHub_act.class);
            this.comunicacion.showMessage("Logeado correctamente");
            this.comunicacion.toggleProgressBar(false);
        }else{
            this.comunicacion.showMessage("Datos Incorrectos");
        }
    }
}
