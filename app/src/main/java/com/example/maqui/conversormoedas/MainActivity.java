package com.example.maqui.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder= new ViewHolder();//viewHolder serve para listar os elementos de forma mais eficiente

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //é necessário fazer o casting em todas, é tipo um polimorfismo.
        this.mViewHolder.editValue=(EditText)findViewById(R.id.edit_value);//vai pegar o elemento do layout e colocar nessa variavel
        this.mViewHolder.textDollar=(TextView)findViewById(R.id.text_dollar);
        this.mViewHolder.textEuro=(TextView)findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate=(Button)findViewById(R.id.button_calculate);
        this.mViewHolder.editCotacaoDollar=(EditText)findViewById(R.id.edit_cotacao_dollar);
        this.mViewHolder.editCotacaoEuro=(EditText)findViewById(R.id.edit_cotacao_euro);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.clearValues();
    }

    //isso facilita na hora de colocar vários botões, pois só colocar no método acima e acrescenta mais uma condição no de baixo
    @Override
    public void onClick(View view) {
        int id= view.getId();

        if(id==R.id.button_calculate){
            //lógica do botão
            Double value= Double.valueOf(this.mViewHolder.editValue.getText().toString());//pega o valor no edit Text e converte para string. Usa o getText para converter
            //this.mViewHolder.buttonCalculate.setText("TESTE"); muda o texto do botão
            Double cotacaoDollar= Double.valueOf(this.mViewHolder.editCotacaoDollar.getText().toString());
            Double cotacaoEuro= Double.valueOf(this.mViewHolder.editCotacaoEuro.getText().toString());
            this.mViewHolder.textDollar.setText(String.format("%.2f", value*cotacaoDollar));
            //this.mViewHolder.textDollar.setText(String.format("%.2f", value*3));
            this.mViewHolder.textEuro.setText(String.format("%.2f", value*cotacaoEuro));
            //this.mViewHolder.textEuro.setText(String.format("%.2f", value*4));
        }
    }

    private void clearValues(){
        this.mViewHolder.textDollar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    private static class ViewHolder{
        EditText editValue;
        TextView textDollar;
        TextView textEuro;
        Button buttonCalculate;
        EditText editCotacaoDollar;
        EditText editCotacaoEuro;
    }
}
