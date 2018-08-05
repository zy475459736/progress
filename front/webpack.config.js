module.exports = {
    devtool: 'eval-source-map',//����source map,�������
    entry:  __dirname + "/app/main.js",//�Ѷ���ἰ��Ψһ����ļ�
    output: {
        path: __dirname + "/public",//�������ļ���ŵĵط�
        filename: "bundle.js"//���������ļ����ļ���
    },
    devServer: {//�������ط����������������޸Ĳ��Զ�ˢ����ʾ�޸ĺ�Ľ����
        contentBase: "./public",//���ط����������ص�ҳ�����ڵ�Ŀ¼
        historyApiFallback: true,//����ת
        inline: true//ʵʱˢ��
    },
    module: {
        rules: [
            {
                test: /(\.jsx|\.js)$/,
                use: {
                    loader: "babel-loader",
                    options: {
                        presets: [
                            "env", "react"
                        ]
                    }
                },
                exclude: /node_modules/
            }
        ]
    }
}