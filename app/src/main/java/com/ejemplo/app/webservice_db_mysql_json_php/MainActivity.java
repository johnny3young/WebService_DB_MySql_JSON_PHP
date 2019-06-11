package com.ejemplo.app.webservice_db_mysql_json_php;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.ejemplo.app.webservice_db_mysql_json_php.fragments.BienvenidaFragment;
import com.ejemplo.app.webservice_db_mysql_json_php.fragments.ConsultaListaUsuarioImagenUrlFragment;
import com.ejemplo.app.webservice_db_mysql_json_php.fragments.ConsultaUsuarioUrlFragment;
import com.ejemplo.app.webservice_db_mysql_json_php.fragments.ConsultarListaUsuariosFragment;
import com.ejemplo.app.webservice_db_mysql_json_php.fragments.ConsultarUsuarioFragment;
import com.ejemplo.app.webservice_db_mysql_json_php.fragments.ConsutarListausuarioImagenFragment;
import com.ejemplo.app.webservice_db_mysql_json_php.fragments.DesarrolladorFragment;
import com.ejemplo.app.webservice_db_mysql_json_php.fragments.RegistrarUsuarioFragment;
import com.ejemplo.app.webservice_db_mysql_json_php.interfaces.IFragments;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IFragments {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Desactivamos el FAB
        //FloatingActionButton fab = findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        Fragment miFragment=new BienvenidaFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        Fragment miFragment=null;
        boolean fragmentSeleccionado=false;

        if (id == R.id.nav_inicio) {
            miFragment=new BienvenidaFragment();
            fragmentSeleccionado=true;
        }else if (id == R.id.nav_registro) {
            miFragment=new RegistrarUsuarioFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_consulta_individual) {
            miFragment=new ConsultarUsuarioFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_consulta_Url) {
            miFragment=new ConsultaUsuarioUrlFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_consulta_gral) {
            miFragment=new ConsultarListaUsuariosFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_consulta_gral_img) {
            miFragment=new ConsutarListausuarioImagenFragment();
            fragmentSeleccionado=true;
        }else if (id == R.id.nav_consulta_gral_img_url) {
            miFragment=new ConsultaListaUsuarioImagenUrlFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_desarrollador) {
            miFragment=new DesarrolladorFragment();
            fragmentSeleccionado=true;
        }

        if (fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction (Uri uri){

    }
}
