public void dialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //configurar titulo e mensagem
        dialog.setTitle("Titúlo da dialog");
        dialog.setMessage("mensagem da dialog");

        //configurar açoes para sim e nâo
        dialog.setPositiveButton("sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Executar açâo ao clicar no botão sim", Toast.LENGTH_SHORT).show();

            }
        });

        dialog.setNegativeButton("nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Executar açâo ao clicar no botão não", Toast.LENGTH_SHORT).show();

            }
        });

        dialog.create();
        dialog.show();


    }
