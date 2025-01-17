PGDMP         .    	            y            cmmi    14.1    14.1 #    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    20623    cmmi    DATABASE     l   CREATE DATABASE "cmmi" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
     DROP DATABASE "cmmi";
                postgres    false            m          0    20740 
   complexity 
   TABLE DATA           .   COPY public.complexity (id, nome) FROM stdin;
    public          postgres    false    215          t          0    21159    conf_skillmix 
   TABLE DATA           b   COPY public.conf_skillmix (id, profilo, allocazione, costo_giornaliero, id_cost_item) FROM stdin;
    public          postgres    false    222   O       r          0    20765    conf_workactivities 
   TABLE DATA           P   COPY public.conf_workactivities (id, attivita, effort, valori_pred) FROM stdin;
    public          postgres    false    220   )       �          0    21237    conf_workitems 
   TABLE DATA           �   COPY public.conf_workitems (id, effort_uni_sviluppo, note, registro_agg_variazioni, id_unit_measure, id_work_item, id_complexity) FROM stdin;
    public          postgres    false    239   �       q          0    20760 	   cost_item 
   TABLE DATA           -   COPY public.cost_item (id, nome) FROM stdin;
    public          postgres    false    219   �       k          0    20730    estimation_type 
   TABLE DATA           3   COPY public.estimation_type (id, nome) FROM stdin;
    public          postgres    false    213           o          0    20750    phase 
   TABLE DATA           )   COPY public.phase (id, nome) FROM stdin;
    public          postgres    false    217   J        g          0    20710    project_scope 
   TABLE DATA           1   COPY public.project_scope (id, nome) FROM stdin;
    public          postgres    false    209   u        i          0    20720    project_technology 
   TABLE DATA           6   COPY public.project_technology (id, nome) FROM stdin;
    public          postgres    false    211   �        h          0    20715    project_type 
   TABLE DATA           0   COPY public.project_type (id, nome) FROM stdin;
    public          postgres    false    210   H!       n          0    20745    release 
   TABLE DATA           +   COPY public.release (id, nome) FROM stdin;
    public          postgres    false    216   �!       p          0    20755    requirement 
   TABLE DATA           /   COPY public.requirement (id, nome) FROM stdin;
    public          postgres    false    218   �!       s          0    21090    stima 
   TABLE DATA           �   COPY public.stima (id, nome_progetto, wbs, descrizione, data_inizio, data_fine, owner_stima, contingency, id_estimationtype, id_project_scope, id_unit_measure, id_project_technology) FROM stdin;
    public          postgres    false    221   �!       u          0    21171 
   stima_item 
   TABLE DATA           �   COPY public.stima_item (id, descrizione, assunzioni, id_release, id_phase, id_requirement, id_work_item, id_complexity, id_workactivities, id_stima, id_conf_skillmix) FROM stdin;
    public          postgres    false    223   g"       j          0    20725    unit_measure 
   TABLE DATA           0   COPY public.unit_measure (id, nome) FROM stdin;
    public          postgres    false    212   �"       l          0    20735 	   work_item 
   TABLE DATA           -   COPY public.work_item (id, nome) FROM stdin;
    public          postgres    false    214   )#       �           0    0    seq_complexity    SEQUENCE SET     =   SELECT pg_catalog.setval('public.seq_complexity', 1, false);
          public          postgres    false    224            �           0    0    seq_conf_skillmix    SEQUENCE SET     @   SELECT pg_catalog.setval('public.seq_conf_skillmix', 1, false);
          public          postgres    false    226            �           0    0    seq_conf_workactivities    SEQUENCE SET     F   SELECT pg_catalog.setval('public.seq_conf_workactivities', 1, false);
          public          postgres    false    225            �           0    0    seq_cost_item    SEQUENCE SET     <   SELECT pg_catalog.setval('public.seq_cost_item', 1, false);
          public          postgres    false    227            �           0    0    seq_estimation_type    SEQUENCE SET     B   SELECT pg_catalog.setval('public.seq_estimation_type', 1, false);
          public          postgres    false    228            �           0    0 	   seq_phase    SEQUENCE SET     8   SELECT pg_catalog.setval('public.seq_phase', 1, false);
          public          postgres    false    229            �           0    0    seq_project_scope    SEQUENCE SET     @   SELECT pg_catalog.setval('public.seq_project_scope', 1, false);
          public          postgres    false    230            �           0    0    seq_project_technology    SEQUENCE SET     E   SELECT pg_catalog.setval('public.seq_project_technology', 1, false);
          public          postgres    false    231            �           0    0    seq_project_type    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.seq_project_type', 1, false);
          public          postgres    false    232            �           0    0    seq_release    SEQUENCE SET     :   SELECT pg_catalog.setval('public.seq_release', 1, false);
          public          postgres    false    233            �           0    0    seq_requirement    SEQUENCE SET     >   SELECT pg_catalog.setval('public.seq_requirement', 1, false);
          public          postgres    false    234            �           0    0 	   seq_stima    SEQUENCE SET     8   SELECT pg_catalog.setval('public.seq_stima', 1, false);
          public          postgres    false    235            �           0    0    seq_stima_item    SEQUENCE SET     =   SELECT pg_catalog.setval('public.seq_stima_item', 1, false);
          public          postgres    false    236            �           0    0    seq_unit_measure    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.seq_unit_measure', 1, false);
          public          postgres    false    237            �           0    0    seq_work_item    SEQUENCE SET     <   SELECT pg_catalog.setval('public.seq_work_item', 1, false);
          public          postgres    false    238            m   #   x�3��MM�,��2���L��2���/������ e3�      t   �   x�m��� @��W��>G_�C�8��+�RS�ѿ�����9�r�c��Em��+ވ`	�(l-��:Z+�~���u_ߤ�k��p���	$�/�vOˊ	����U6Cύ�TT6�/fP����.���}����>:9�g���(��0��t�{�¡�ƳR�@*��!�[�̖����V�e�H)�:K�#��B_
ɂ�      r   �   x�]N�
�0��{���ҦF]�R�
��%h�|%I;����$�p��b�եh�ӡm*H��6pf�����ëRt0�\8zlf��2ϒ�(��{?�� 1&7�d�,�)/��mA�	����m����_�5��-5��{����'�j2h      �     x���KN�0�מS��Q�*!Z	�����eTǃl�J=w�bL}��*�"+�4��c+����ݚڸ�7H��9�����k�lB�%9ۺ0jY�4oU����PjS᎒@*�Am��B&R�GF��f�y��Ƕ�#C�3��gi�囑�'��-�\0���5����Z��n\��a�n������)F/M�1��<j+��l ��؜���]��@����ŔS��mB y�����8�R=R��}T�{�ٻ���+ ��4��      q   -   x�3�tI�̩Tp�/.QI�I-H,.�2B5�2F�s��qqq �      k       x�3���L�P�I-K��2���/��c���� ��      o      x�3��H,NU0�2����b���� RW�      g   ^   x�3���w�2�t,.N-.�M�+�2�t�K�-��R\&�.�e�9� )5ϼ����Ē��<�����b.S���Ĝ̒J��E�yɩ\1z\\\ 
�      i   U   x�3���w�2�t
Pv�2�t�UN�I-N�/JN�2��'r�r:�(x%�%r�q�f&���eVer�s�;p��qqq 9��      h   1   x�3�t,(��LN,���SpI-K��/�M�+�2�.I,*)-������ )�<      n      x�3�J�IM,NU0�2����b���� yIW      p   3   x�3���O�L�LNT(M�.M�2B����+�$�$����s��qqq ��      s   ^   x�3�I�I-H,.V�,I,J�T��K�/J��T�LLJN1426�t�5�4�4204�#ӈ�9�('_! 1''1%3/�(k�i��\1z\\\ ï�      u   �   x�M�M
�@����)r��#���&M3h�ɴ��x��ׇ�������eǙ���x�l��M�a�j�aB⥺,��CL���ݻ��|iHNH$�:lKڧ�3N��>��lb�OB5�      j       x�3�tw��2��� �Ɯnn\1z\\\ K�      l   k   x�3���L.�/N-*ˬ��WJ-.�2���+IM/J���*��xss���g&g�*����s�p�$�$����s�r�&��&q�q��e��sK�R�b���� �� �     
